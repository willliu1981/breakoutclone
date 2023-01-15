package idv.game.breakoutclone.breakoutclone.testframe;

import java.awt.Graphics;

import javax.swing.JLabel;

import idv.game.breakoutclone.frame.graphics.paint.ColliderPainter;
import idv.game.breakoutclone.frame.graphics.paint.CollisionPainter;
import idv.game.breakoutclone.frame.graphics.paint.Paintable;
import idv.game.breakoutclone.system.Scenes;
import idv.game.breakoutclone.system.physics.Locations;
import idv.game.breakoutclone.system.physics.Physics;
import idv.game.breakoutclone.system.physics.Point;
import idv.game.breakoutclone.system.physics.Ray;
import idv.game.breakoutclone.system.physics.RayCastHit;

public class SimulationPaintable implements FramePaintable {
	private JLabel lblInfo2;
	private JLabel lblInfo3;
	private JLabel lblInfo1;
	private JLabel lblInfo4;

	@Override
	public void paint(Graphics g) {
		// params
		final double rayLength = 558;
		final double p0Angle = 20;

		CollisionPainter collisionPainter = new CollisionPainter();
		ColliderPainter colliderPainter = new ColliderPainter();
		Scenes.getGameObjects().stream().forEach(go -> {
			collisionPainter.paint(g, go.getLocation());

			go.getColliders().stream().forEach(c -> {
				Point translateToWorldLocation = Locations.translateToWorldLocation(c, new Point());
				colliderPainter.setX(translateToWorldLocation.x);
				colliderPainter.setY(translateToWorldLocation.y);
				colliderPainter.paint(g, (Paintable) c);
			});
		});

		Point p0 = new Point(60, 233);
		Point nextMove = Physics.nextMove(p0, p0Angle, rayLength);

		Ray ray = new Ray(p0, nextMove);

		collisionPainter.paint(g, ray);

		RayCastHit hit = new RayCastHit();
		boolean isCollided = Physics.Raycast(ray, hit, rayLength);

		collisionPainter.paint(g, hit.getFirstCollidePoint());
		if (!isCollided) {
			lblInfo1.setText("沒有碰撞");
		} else {
			String collidePointStr = hit.getFirstCollidePoint().toString();
			double incidenceAngle1 = Locations.getIncidenceAngle(hit.getFirstCollidePoint(), p0,
					hit.getFirstCollideLine().getP0());
			double incidenceAngle2 = Locations.getIncidenceAngle(hit.getFirstCollidePoint(), p0,
					hit.getFirstCollideLine().getP1());

			double reflectionAngle = Locations.getReflectionAngle(p0Angle, Math.min(incidenceAngle1, incidenceAngle2));
			Ray rflRay = new Ray(hit.getFirstCollidePoint(),
					Physics.nextMove(hit.getFirstCollidePoint(), reflectionAngle, 100));
			collisionPainter.paint(g, rflRay);

			// textBox
			lblInfo1.setText("collide point:" + collidePointStr);
			lblInfo2.setText("incidenceAngle 1:" + incidenceAngle1);
			lblInfo3.setText("incidenceAngle 2:" + incidenceAngle2);
			lblInfo4.setText("reflectionAngle:" + reflectionAngle);

		}

		// hit.getHits().forEach(h -> System.out.println(h.getCollidePoint()));
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
