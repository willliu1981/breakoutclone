package idv.game.breakoutclone.breakoutclone.collider;

public abstract class BaseRectangle {
	protected double round_length;//圓角
	protected double width;
	protected double height;

	public abstract double getRound_length();

	public abstract void setRound_length(double round_length);

	public abstract double getWidth();

	public abstract void setWidth(double width);

	public abstract double getHeight();

	public abstract void setHeight(double height);

	public abstract double getFixedWidth();

	public abstract double getFixedHeigth();

	@Override
	public String toString() {
		return "BaseRectangle [getRound_length()=" + getRound_length()
				+ ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight()
				+ ", getFixedWidth()=" + getFixedWidth() + ", getFixedHeigth()="
				+ getFixedHeigth() + "]";
	}

	
	
}
