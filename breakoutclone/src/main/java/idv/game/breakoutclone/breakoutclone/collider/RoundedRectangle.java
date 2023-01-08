package idv.game.breakoutclone.breakoutclone.collider;

import idv.game.breakoutclone.system.physics.Point;

public class RoundedRectangle extends SolvedRoundedRectangle {

	public RoundedRectangle() {
		super();
	}

	public RoundedRectangle(double width, double height) {
		this(width, height, 0);
	}

	public RoundedRectangle(double width, double height, double round_length) {
		this.setWidth(width);
		this.setHeight(height);
		this.setRound_length(round_length);
	}
	
	

}
