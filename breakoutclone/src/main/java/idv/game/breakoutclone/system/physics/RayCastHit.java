package idv.game.breakoutclone.system.physics;

import java.util.ArrayList;
import java.util.List;

public class RayCastHit {

	List<? extends Hit> hits = new ArrayList<>();

	public List<? extends Hit> getHits() {
		return hits;
	}

	public void setHits(List<? extends Hit> hits) {
		this.hits = hits;
	}

	public Point getFirstCollidePoint() {
		return this.hits.isEmpty() ? null : hits.get(0).getCollidePoint();
	}

	public Line getFirstCollideLine() {
		return this.hits.isEmpty() ? null : hits.get(0).getCollideLine();
	}

}
