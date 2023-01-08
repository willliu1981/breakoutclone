package idv.game.breakoutclone.system.physics;

import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public class Ray implements Paintable {
	Point p0;
	Point p1;

	public Ray() {
		super();
	}

	public Ray(Point p0, Point p1) {
		super();
		this.p0 = p0;
		this.p1 = p1;
	}

	
	
	public synchronized Point getP0() {
		return p0;
	}

	public synchronized Point getP1() {
		return p1;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", p1=" + p1 + "]";
	}

}
