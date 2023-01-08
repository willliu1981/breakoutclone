package idv.game.breakoutclone.system.physics;

import idv.game.breakoutclone.collider.Collider;

public class RayLineCastHit extends Hit {

	Collider owner;

	public Collider getOwner() {
		return owner;
	}

	public void setOwner(Collider owner) {
		this.owner = owner;
	}

}
