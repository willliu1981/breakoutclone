package idv.game.breakoutclone.collider;

import idv.game.breakoutclone.gameobject.GameObject;

public abstract class Collider {
	protected double x;
	protected double y;
	protected GameObject owner;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public GameObject getOwner() {
		return owner;
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

}
