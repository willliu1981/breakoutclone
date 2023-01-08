package idv.game.breakoutclone.system.location;

import idv.game.breakoutclone.collider.Collider;
import idv.game.breakoutclone.system.physics.Point;

public class Locations {
	public static Point translateToWorldLocation(Collider parent, Point p) {
		Point location = parent.getOwner().getLocation();

		return new Point(location.x + parent.getX() + p.x,
				location.y + parent.getY() + p.y);
	}
}
