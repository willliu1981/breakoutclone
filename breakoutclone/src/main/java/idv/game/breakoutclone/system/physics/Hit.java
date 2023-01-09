package idv.game.breakoutclone.system.physics;

public abstract class Hit {
	Point collidePoint;
	double distance;
	Line collideLine;

	public void setCollidePoint(Point collidePoint) {
		this.collidePoint = collidePoint;
	}

	public Point getCollidePoint() {
		return collidePoint;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Line getCollideLine() {
		return collideLine;
	}

	public void setCollideLine(Line collideLine) {
		this.collideLine = collideLine;
	}

}
