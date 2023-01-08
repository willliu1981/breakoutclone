package idv.game.breakoutclone.breakoutclone.collider;

public class Rectangle extends SolvedRoundedRectangle {

	public Rectangle() {
		super();
	}

	public Rectangle(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	public void setRound_length(double round_length) {
		//nothing
	}

}
