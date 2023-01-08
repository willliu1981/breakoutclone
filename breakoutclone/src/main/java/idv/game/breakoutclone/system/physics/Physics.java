package idv.game.breakoutclone.system.physics;

import org.junit.jupiter.api.Test;

public class Physics {

	static public double calcDistance(Point p0, Point p1) {
		double dist = Math.pow(
				(p1.x - p0.x) * (p1.x - p0.x) + (p1.y - p0.y) * (p1.y - p0.y),
				0.5);

		return dist;
	}

	static public Point nextMove(Point p0, double velocity, double degree) {

		double x = velocity * Math.cos(Math.toRadians(degree));
		double y = velocity * Math.sin(Math.toRadians(degree));

		return new Point(p0.x + x, p0.y + y);
	}

	static public boolean Raycast(Ray ray, Ray targeLine, RayCastHit hit,
			double distance) {

		Point rayIntersectPoint = rayIntersectPoint(ray.getP0(), ray.getP1(),
				targeLine.p0, targeLine.p1);

		boolean boolCollided = false;

		if (rayIntersectPoint == null) {
			return false;
		}

		if (distance < calcDistance(ray.p0, rayIntersectPoint)) {
			return false;
		}

		try {
			//方向同異
			if (ray.p0.x != rayIntersectPoint.x) {
				if ((ray.p1.x - ray.p0.x)
						* (rayIntersectPoint.x - ray.p0.x) > 0) {
					boolCollided = true;
					System.out.println("t1");
				}
			} else if ((ray.p0.y != rayIntersectPoint.y)) {
				if ((ray.p1.y - ray.p0.y)
						* (rayIntersectPoint.y - ray.p0.y) > 0) {
					boolCollided = true;
					System.out.println("t2");
				}
			} else {
				throw new Exception("發生碰撞重疊");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (boolCollided) {
			hit.setCollidePoint(rayIntersectPoint);
		}

		return boolCollided;
	}

	static private Point rayIntersectPoint(Point rayP1, Point rayP2,
			Point targetP1, Point targetP2) {
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
		Point p0 = new Point(100, 100);
		Point nextMove = Physics.nextMove(p0, 10, 45);

		Point t1 = new Point(100, 200);
		Point t2 = new Point(200, 100);

		Point collidePoint = Physics.rayIntersectPoint(p0, nextMove, t1, t2);

		System.out.println("physics " + collidePoint);

	}

}
