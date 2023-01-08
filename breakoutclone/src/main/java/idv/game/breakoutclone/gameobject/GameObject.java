package idv.game.breakoutclone.gameobject;

import java.util.ArrayList;
import java.util.List;

import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.system.physics.Point;

public class GameObject {
	Point location;
	List<Collider> colliders = new ArrayList<>();

	public void addCollider(Collider collider) {
		this.colliders.add(collider);
		collider.setOwner(this);
	}

	public List<Collider> getColliders() {
		return colliders;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
