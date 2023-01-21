package idv.game.breakoutclone.collider;

import idv.game.breakoutclone.frame.graphics.paint.Paintable;

public abstract class BaseRectangle extends Collider implements Paintable {
	protected double round_length;// 圓角
	protected double width;
	protected double height;

	private static BaseRectangle creator = new BaseRectangle() {

		@Override
		public double getRound_length() {
			return 0;
		}

		@Override
		public void setRound_length(double round_length) {

		}

		@Override
		public double getWidth() {
			return 0;
		}

		@Override
		public void setWidth(double width) {

		}

		@Override
		public double getHeight() {
			return 0;
		}

		@Override
		public void setHeight(double height) {

		}

		@Override
		public double getFixedWidth() {
			return 0;
		}

		@Override
		public double getFixedHeigth() {
			return 0;
		}

	};

	protected BaseRectangle() {
		super();
	}

	public static BaseRectangle prepareCteate(String name) {
		try {
			creator.product = (Collider) Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return creator;
	}
	
	public BaseRectangle setSize(double width,double height) {
		((BaseRectangle) (creator.product)).setWidth(width);
		((BaseRectangle) (creator.product)).setHeight(height);
		return this;
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
