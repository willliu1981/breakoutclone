package idv.game.breakoutclone.frame.graphics.paint;

public abstract class PainterFactory {
	public static final String COLLIDERPAINTER = "colliderPainter";
	public static final String COLLISIONPAINTER = "collisionPainter";

	private static Painter colliderPainter = new ColliderPainter();
	private static Painter collisionPainter = new CollisionPainter();

	public static <T> T getPainter(String painterName, Class<T> clazz) {

		try {
			String name = null;
			switch (painterName) {
			case COLLIDERPAINTER:
				name = colliderPainter.getClass().getName();
				break;
			case COLLISIONPAINTER:
				name = collisionPainter.getClass().getName();
				break;

			default:
				name = "";
			}

			Class<T> painter = (Class<T>) Class.forName(name);
			return (T) painter.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

}
