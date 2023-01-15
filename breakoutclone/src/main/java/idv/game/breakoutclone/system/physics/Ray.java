package idv.game.breakoutclone.system.physics;

import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public class Ray implements Paintable {
	Point p0;
	Point p1;

	public Ray() {
		super();
	}

	/**
	 * 
	 * @param p0
	 * @param p1
	 * @param length 重設長度
	 */
	public Ray(Point p0, Point p1, double length) {
		this(p0, p1);

		double distance = Physics.calcDistance(p0, p1);
		double rate = length / distance;
		this.p1 = new Point(this.getP0().x + (this.p1.x - this.p0.x) * rate,
				this.getP0().y + (this.p1.y - this.p0.y) * rate);
	}

	public Ray(Point p0, Point p1) {
		super();
		this.p0 = p0;
		this.p1 = p1;
	}

	public Point getP0() {
		return p0;
	}

	public Point getP1() {
		return p1;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", p1=" + p1 + "]";
	}

}
