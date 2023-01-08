package idv.game.breakoutclone.system.physics;

public class Line extends Ray {

	public Line() {
		super();
	}

	public Line(Point p0, Point p1) {
		super(p0, p1);
	}

	@Override
	public String toString() {
		return "Line [p0=" + p0 + ", p1=" + p1 + "]";
	}

}
