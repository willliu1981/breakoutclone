package idv.game.breakoutclone.collider;

import org.junit.jupiter.api.Test;

public class Rectangle extends SolvedRoundedRectangle {

	protected Rectangle() {
		super();
	}

	private Rectangle(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
		this.setX(-width / 2);
		this.setY(-height / 2);
	}

	@Override
	public void setRound_length(double round_length) {
		// nothing
	}

	@Test
	public void test() {

		Collider createNewOne = Collider.prepareCteate(Collider.RECTANGLE).setLocation(1, 2).createNewOne();
		System.out.println("" + createNewOne);
	}
}
