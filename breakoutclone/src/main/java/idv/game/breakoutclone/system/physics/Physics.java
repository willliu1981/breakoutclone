package idv.game.breakoutclone.system.physics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.collider.Rectangle;
import idv.game.breakoutclone.gameobject.GameObject;
import idv.game.breakoutclone.system.Scenes;

public class Physics {

	static public double calcDistance(Point p0, Point p1) {
		double dist = Math.pow((p1.x - p0.x) * (p1.x - p0.x) + (p1.y - p0.y) * (p1.y - p0.y), 0.5);

		return dist;
	}

	static public Point nextPoint(Point p0, double degree, double velocity) {

		double x = velocity * Math.cos(Math.toRadians(degree));
		double y = velocity * Math.sin(Math.toRadians(degree));

		return new Point(p0.x + x, p0.y + y);
	}

	static public boolean Raycast(Ray ray, RayCastHit hit, double distance) {

		List<GameObject> gameObjects = Scenes.getGameObjects();
		List<RayLineCastHit> RLCastHits = new ArrayList<>();

		gameObjects.forEach(g -> {
			List<Collider> colliders = g.getColliders();
			colliders.forEach(c -> {
				if (c instanceof Rectangle) {
					Rectangle rect = (Rectangle) c;

					Point p1 = Locations.translateToWorldLocation(c, new Point());
					Point p2 = Locations.translateToWorldLocation(c, new Point(rect.getWidth(), 0));
					Point p3 = Locations.translateToWorldLocation(c, new Point(rect.getWidth(), rect.getHeight()));
					Point p4 = Locations.translateToWorldLocation(c, new Point(0, rect.getHeight()));

					Arrays.asList(new Line(p1, p2), new Line(p2, p3), new Line(p3, p4), new Line(p4, p1)).stream()
							.forEach(l -> {
								RayLineCastHit h = new RayLineCastHit();
								if (Raycast(ray, l, h, distance)) {
									h.setOwner(c);
									RLCastHits.add(h);
								}
							});
				}
			});
		});

		List<RayLineCastHit> reslult = RLCastHits.stream().sorted((h1, h2) -> {
			int flag = (int) (h1.getDistance() - h2.getDistance());

			return flag > 0 ? 1 : flag < 0 ? -1 : 0;
		}).collect(Collectors.toList());

		hit.setHits(reslult);

		return hit.getFirstCollidePoint() == null ? false : true;
	}

	static public boolean Raycast(Ray ray, Line targetLine, RayLineCastHit hit, double distance) {

		Point rayIntersectPoint = rayIntersectPoint(ray.getP0(), ray.getP1(), targetLine.p0, targetLine.p1);
		double targetDistance = 0;

		if (rayIntersectPoint == null) {
			return false;
		}

		// 不在目標邊上
		double tolerance = 0.1;
		if (!(rayIntersectPoint.x >= -tolerance + Math.min(targetLine.p0.x, targetLine.p1.x)
				&& rayIntersectPoint.x <= tolerance + Math.max(targetLine.p0.x, targetLine.p1.x)
				&& rayIntersectPoint.y >= -tolerance + Math.min(targetLine.p0.y, targetLine.p1.y)
				&& rayIntersectPoint.y <= tolerance + Math.max(targetLine.p0.y, targetLine.p1.y))) {
			return false;
		}

		// 在目標距離外
		if (distance < (targetDistance = calcDistance(ray.p0, rayIntersectPoint))) {

			return false;
		}
		// 方向同異
		if (ray.p0.x != rayIntersectPoint.x) {
			if ((ray.p1.x - ray.p0.x) * (rayIntersectPoint.x - ray.p0.x) > 0) {
				hit.setCollidePoint(rayIntersectPoint);
				hit.setDistance(targetDistance);
				hit.setCollideLine(targetLine);
				return true;
			}
		}

		return false;
	}

	static private Point rayIntersectPoint(Point rayP1, Point rayP2, Point targetP1, Point targetP2) {
		double A1 = rayP1.y - rayP2.y;
		double B1 = rayP2.x - rayP1.x;
		double C1 = A1 * rayP1.x + B1 * rayP1.y;

		double A2 = targetP1.y - targetP2.y;
		double B2 = targetP2.x - targetP1.x;
		double C2 = A2 * targetP1.x + B2 * targetP1.y;

		double det_k = A1 * B2 - A2 * B1;

		if (Math.abs(det_k) < 0.00001) {
			return null;
		}

		double a = B2 / det_k;
		double b = -1 * B1 / det_k;
		double c = -1 * A2 / det_k;
		double d = A1 / det_k;

		double x = a * C1 + b * C2;
		double y = c * C1 + d * C2;

		Point p = new Point(x, y);

		return p;
	}

	@Test
	public void test() {
		double calcDistance = Physics.calcDistance(new Point(0, 0), new Point(-100, -100));
		System.out.println("P " + calcDistance);
	}

}
