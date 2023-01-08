package idv.game.breakoutclone.collider;

public class Rectangle extends SolvedRoundedRectangle {

	public Rectangle() {
		super();
	}

	public Rectangle(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
		this.setX(-width / 2);
		this.setY(-height / 2);
	}

	@Override
	public void setRound_length(double round_length) {
		//nothing
	}

}
