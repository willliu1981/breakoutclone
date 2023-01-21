package idv.game.breakoutclone.collider;

public class RoundedRectangleColliderFactory {
	public static final String RECTANGLE = Rectangle.class.getName();

	private Collider creator;

	public RoundedRectangleColliderFactory prepareCreate(String name) {
		creator = Collider.prepareCteate(name);
		/*
		 * try { creator = (BaseRectangle) Class.forName(name).newInstance(); } catch
		 * (InstantiationException | IllegalAccessException | ClassNotFoundException e)
		 * { e.printStackTrace(); } //
		 */
		return this;
	}

	public RoundedRectangleColliderFactory setLocation(double x, double y) {
		creator.setLocation(x, y);
		return this;
	}

	public BaseRectangle createNewOne() {
		return (BaseRectangle) creator.createNewOne(BaseRectangle.class);
	}
}
