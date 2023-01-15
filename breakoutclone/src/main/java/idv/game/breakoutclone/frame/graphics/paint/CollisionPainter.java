package idv.game.breakoutclone.frame.graphics.paint;

import java.awt.Color;
import java.awt.Graphics;

import idv.game.breakoutclone.system.physics.Point;
import idv.game.breakoutclone.system.physics.Ray;
import idv.game.breakoutclone.system.physics.Vector;

public class CollisionPainter extends Painter {

	@Override
	public void paint(Graphics g, Paintable paint) {
		Graphics g2 = g.create();

		if (color != null) {
			g2.setColor(color);
		}

		if (paint instanceof Ray) {
			Ray ray = (Ray) paint;
			g2.drawLine((int) ray.getP0().x, (int) ray.getP0().y, (int) ray.getP1().x, (int) ray.getP1().y);

		} else if (paint instanceof Point) {
			Point p = (Point) paint;
			g2.fillOval((int) p.x - 2, (int) p.y - 2, 6, 6);
		} else if (paint == null) {
			System.out.println("CollisionPainter throw ecxeption : Point is null");
		}

	}

}
