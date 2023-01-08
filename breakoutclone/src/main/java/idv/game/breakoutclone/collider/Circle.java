package idv.game.breakoutclone.collider;

public class Circle extends SolvedRoundedRectangle {

	public Circle() {
		super();
	}

	public Circle(double round_length) {
		super.setWidth(round_length * 2);
		super.setHeight(round_length * 2);
		this.setRound_length(round_length);
	}

	@Override
	public void setWidth(double width) {
		//nothing
	}

	@Override
	public void setHeight(double height) {
		//nothing
	}

}
