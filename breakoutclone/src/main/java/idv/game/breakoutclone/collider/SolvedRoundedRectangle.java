package idv.game.breakoutclone.collider;

public class SolvedRoundedRectangle extends BaseRectangle {

	protected SolvedRoundedRectangle() {
		super();
	}

	@Override
	public double getRound_length() {
		return this.round_length;
	}

	@Override
	public void setRound_length(double round_length) {
		double min = Math.min(this.width, this.height);
		if (round_length < 0) {
			round_length = 0;
		}

		if (round_length >= min / 2.0) {
			this.round_length = min / 2.0;
		} else {
			this.round_length = round_length;
		}

	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public void setWidth(double width) {
		if (width < 0) {
			this.width = 0;
		} else {
			this.width = width;
		}

		this.setRound_length(this.round_length);
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public void setHeight(double height) {
		if (height < 0) {
			this.height = 0;
		} else {
			this.height = height;
		}

		this.setRound_length(this.round_length);
	}

	public double getFixedWidth() {
		double fixed = this.width - this.round_length * 2;
		return fixed < 0 ? 0 : fixed;
	}

	public double getFixedHeigth() {
		double fixed = this.height - this.round_length * 2;
		return fixed < 0 ? 0 : fixed;
	}



}
