package idv.game.breakoutclone.frame.graphics.paint;

public abstract class PainterFactory {
	public static final String COLLIDERPAINTER = ColliderPainter2.class.getName();
	public static final String COLLISIONPAINTER = CollisionPainter.class.getName();

	public static Painter getPainter(String painterName) {
		return getPainter(painterName, Painter.class);
	}

	public static <T> T getPainter(String painterName, Class<T> clazz) {

		try {
			Class<T> painter = (Class<T>) Class.forName(painterName);
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
