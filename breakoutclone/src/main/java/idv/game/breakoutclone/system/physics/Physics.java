package idv.game.breakoutclone.system.physics;

import org.junit.jupiter.api.Test;

import idv.game.breakoutclone.frame.graphics.paint.CollisionPainter;
import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public class Physics {

	static public Point nextMove(Point p0, double velocity, double degree) {

		double x = velocity * Math.cos(Math.toRadians(degree));
		double y = velocity * Math.sin(Math.toRadians(degree));

		return new Point(p0.x + x, p0.y + y);
	}

	static public void collide(Ray ray) {

	}

	static public Point collidePoint(Point rayP1, Point rayP2, Point targetP1,
			Point targetP2) {
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

		Point collidePoint = Physics.collidePoint(p0, nextMove, t1, t2);

		System.out.println("physics " + collidePoint);

	}

}
