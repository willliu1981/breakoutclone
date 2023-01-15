package idv.game.breakoutclone.system.physics;

public class Vector extends Point {

	public Vector() {
		super();
	}

	public Vector(double x, double y) {
		super(x, y);
	}

	public Vector(Point p0, Point p1) {
		super(p1.x - p0.x, p1.y - p0.y);
	}

}
