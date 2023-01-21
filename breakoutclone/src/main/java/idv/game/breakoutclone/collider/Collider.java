package idv.game.breakoutclone.collider;

import java.util.ArrayList;
import java.util.List;

import idv.game.breakoutclone.gameobject.GameObject;
import idv.game.breakoutclone.system.physics.Point;

public abstract class Collider {
	public static final String RECTANGLE = "Rectangle";
	protected double x;
	protected double y;
	protected Point pivot;
	protected GameObject owner;
	protected List<Point> vertices = new ArrayList<>();

	private static Collider creator = new Collider() {

	};

	protected Collider product;

	protected Collider() {

	}

	public static Collider prepareCteate(String name) {
		try {
			creator.product = (Collider) Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return creator;
	}

	public Collider setLocation(double x, double y) {
		product.x = x;
		product.y = y;
		return creator;
	}

	public <T> Collider createNewOne(Class<T> clazz) {
		return product;
	}

	public Collider createNewOne() {
		return product;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public GameObject getOwner() {
		return owner;
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

	public Point getPivot() {
		return pivot;
	}

	public void setPivot(Point pivot) {
		this.pivot = pivot;
	}

	public List<Point> getVertices() {
		return vertices;
	}

	public void setVertices(List<Point> vertices) {
		this.vertices = vertices;
	}

}
