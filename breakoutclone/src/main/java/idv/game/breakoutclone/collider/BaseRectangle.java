package idv.game.breakoutclone.collider;

import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public abstract class BaseRectangle extends Collider implements Paintable {
	protected double round_length;// 圓角
	protected double width;
	protected double height;

	protected BaseRectangle() {
		super();
	}

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
		return "BaseRectangle [getRound_length()=" + getRound_length() + ", getWidth()=" + getWidth() + ", getHeight()="
				+ getHeight() + ", getFixedWidth()=" + getFixedWidth() + ", getFixedHeigth()=" + getFixedHeigth()
				+ ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}

}
