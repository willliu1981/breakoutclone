package idv.game.breakoutclone.system.physics;

public class RayCastHit {

	Point collidePoint;

	public synchronized void setCollidePoint(Point collidePoint) {
		this.collidePoint = collidePoint;
	}

	public synchronized Point getCollidePoint() {
		return collidePoint;
	}

}
