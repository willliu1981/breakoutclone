package idv.game.breakoutclone.collider;

public class RoundedRectangleColliderFactory {
	public static final String RECTANGLE = Rectangle.class.getName();

	private BaseRectangle creator;

	public RoundedRectangleColliderFactory prepareCreate(String name) {
		creator = BaseRectangle.prepareCteate(name);
		return this;
	}

	public RoundedRectangleColliderFactory setLocation(double x, double y) {
		creator.setLocation(x, y);
		return this;
	}

	public RoundedRectangleColliderFactory setSize(double width, double height) {
		creator.setSize(width, height);
		return this;
	}

	public BaseRectangle createNewOne() {
		return (BaseRectangle) creator.createNewOne(BaseRectangle.class);
	}
}
