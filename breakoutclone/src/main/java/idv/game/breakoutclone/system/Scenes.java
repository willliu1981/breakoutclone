package idv.game.breakoutclone.system;

import java.util.ArrayList;
import java.util.List;

import idv.game.breakoutclone.gameobject.GameObject;

public class Scenes {
	private static List<GameObject> gameObjects = new ArrayList<>();

	public static void addGameObject(GameObject o) {
		gameObjects.add(o);
	}

	public static List<GameObject> getGameObjects() {
		return gameObjects;
	}
}
