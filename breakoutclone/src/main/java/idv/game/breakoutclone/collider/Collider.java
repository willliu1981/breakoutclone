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

	private static Collider singleton = new Collider() {
	};

	private Collider product;

	protected Collider() {

	}

	public static Collider prepareCteate(String name) {
		try {
			singleton.product = (Collider) Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return singleton;
	}

	public Collider setLocation(double x, double y) {
		singleton.product.x = x;
		singleton.product.y = y;
		return singleton;
	}

	public <T> Collider createNewOne(Class<T> clazz) {
		return singleton.product;
	}

	public Collider createNewOne() {
		return singleton.product;
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
