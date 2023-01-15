package idv.game.breakoutclone.breakoutclone.testframe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import idv.game.breakoutclone.frame.graphics.paint.ColliderPainter;
import idv.game.breakoutclone.frame.graphics.paint.CollisionPainter;
import idv.game.breakoutclone.frame.graphics.paint.Paintable;
import idv.game.breakoutclone.system.Scenes;
import idv.game.breakoutclone.system.physics.Line;
import idv.game.breakoutclone.system.physics.Locations;
import idv.game.breakoutclone.system.physics.Physics;
import idv.game.breakoutclone.system.physics.Point;
import idv.game.breakoutclone.system.physics.Ray;
import idv.game.breakoutclone.system.physics.RayCastHit;
import idv.game.breakoutclone.system.physics.RayLineCastHit;
import idv.game.breakoutclone.system.physics.Vector;

public class SimulationPaintable implements FramePaintable {
	private JLabel lblInfo2;
	private JLabel lblInfo3;
	private JLabel lblInfo1;
	private JLabel lblInfo4;

	@Override
	public void paint(Graphics g) {
		// params
		final double RAYLENGTH = 260;
		final double P0ANGLE = 20;
		final double NORMALLENGTH = 50;
		final Color NORMALCOLOR = new Color(0, 122, 0);

		CollisionPainter collisionPainter = new CollisionPainter();
		ColliderPainter colliderPainter = new ColliderPainter();
		Vector normal = null;
		Ray normalRay = null;
		Vector reflectionVector = null;
		Ray reflectionRay = null;

		// 繪製物體中心點
		Scenes.getGameObjects().stream().forEach(go -> {
			collisionPainter.paint(g, go.getLocation());

			// 繪製物體碰撞線
			go.getColliders().stream().forEach(c -> {
				Point translateToWorldLocation = Locations.translateToWorldLocation(c, new Point());
				colliderPainter.setX(translateToWorldLocation.x);
				colliderPainter.setY(translateToWorldLocation.y);
				colliderPainter.paint(g, (Paintable) c);
			});
		});

		Point p0 = new Point(60, 233);
		Point p1 = new Point(120, 266);
		Point nextMove = Physics.nextPoint(p0, P0ANGLE, RAYLENGTH);

		Ray ray = new Ray(p0, p1, RAYLENGTH);

		// 繪製入射角射線
		collisionPainter.setColor(Color.red);
		collisionPainter.paint(g, ray);

		RayCastHit hit = new RayCastHit();
		boolean isCollided = Physics.Raycast(ray, hit, RAYLENGTH);

		// 繪製碰撞點
		collisionPainter.setColor(Color.magenta);
		collisionPainter.paint(g, hit.getFirstCollidePoint());
		if (!isCollided) {
			lblInfo1.setText("沒有碰撞");
		} else {
			String collidePointStr = hit.getFirstCollidePoint().toString();
			double incidenceAngle1 = Locations.getIncidenceAngle(hit.getFirstCollidePoint(), p0,
					hit.getFirstCollideLine().getP0());
			double incidenceAngle2 = Locations.getAngle(hit.getFirstCollidePoint(), p0,
					hit.getFirstCollideLine().getP1());

			// 繪製碰撞法線
			normal = Locations.getNormal(hit.getFirstCollidePoint(), hit.getFirstCollideLine().getP0(), p0);
			normalRay = new Ray(hit.getFirstCollidePoint(),
					new Point(normal.x + hit.getFirstCollidePoint().x, normal.y + hit.getFirstCollidePoint().y),
					NORMALLENGTH);
			collisionPainter.setColor(NORMALCOLOR);
			collisionPainter.paint(g, normalRay);

			// 繪製反射射線
			reflectionVector = Locations.getReflectionVector(new Vector(p0, p1), normal);
			reflectionRay = new Ray(hit.getFirstCollidePoint(),
					Physics.nextPoint(hit.getFirstCollidePoint(), reflectionVector), RAYLENGTH);
			collisionPainter.setColor(Color.blue);
			collisionPainter.paint(g, reflectionRay);

			// textBox
			lblInfo1.setText("collide point:" + collidePointStr);
			lblInfo2.setText("incidenceAngle 1:" + incidenceAngle1);
			lblInfo3.setText("incidenceAngle 2:" + incidenceAngle2);
			// lblInfo4.setText("normal:" + normal);

		}

		// hit.getHits().forEach(h -> System.out.println(h.getCollidePoint()));

		RayLineCastHit testLineHit = new RayLineCastHit();
		Line testLine = new Line(new Point(210, 350), new Point(220, 213));
		// 繪製測試線&法線
		collisionPainter.setColor(Color.gray);
		collisionPainter.paint(g, testLine);
		if (Physics.Raycast(ray, testLine, testLineHit, RAYLENGTH)) {
			normal = Locations.getNormal(testLineHit.getCollidePoint(), testLine.getP0(), p0);
			normalRay = new Ray(testLineHit.getCollidePoint(),
					new Point(normal.x + testLineHit.getCollidePoint().x, normal.y + testLineHit.getCollidePoint().y),
					NORMALLENGTH);

			collisionPainter.setColor(NORMALCOLOR);
			collisionPainter.paint(g, normalRay);

			reflectionVector = Locations.getReflectionVector(new Vector(p0, p1), normal);
			reflectionRay = new Ray(testLineHit.getCollidePoint(),
					Physics.nextPoint(testLineHit.getCollidePoint(), reflectionVector), RAYLENGTH);
			collisionPainter.setColor(Color.blue);
			collisionPainter.paint(g, reflectionRay);
			System.out.println("SP test reflectionVector" + reflectionVector);
			System.out.println("SP test reflectionRay" + reflectionRay);
		}

	}

	public void setLblInfo2(JLabel lblInfo2) {
		this.lblInfo2 = lblInfo2;
	}

	public void setLblInfo3(JLabel lblInfo3) {
		this.lblInfo3 = lblInfo3;
	}

	public void setLblInfo1(JLabel lblInfo1) {
		this.lblInfo1 = lblInfo1;
	}

	public void setLblInfo4(JLabel lblInfo4) {
		this.lblInfo4 = lblInfo4;
	}

}
