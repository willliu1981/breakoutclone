package idv.game.breakoutclone.system.physics;

public abstract class Hit {
	Point collidePoint;
	double distance;

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
}
