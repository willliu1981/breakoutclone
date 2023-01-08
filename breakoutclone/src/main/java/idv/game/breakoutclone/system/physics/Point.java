package idv.game.breakoutclone.system.physics;

import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public class Point implements Paintable {
	public double x;
	public double y;

	public Point() {
		super();
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
