package game;

import gameObjects.Enemy;
import gameObjects.GameObject;

import java.util.ArrayList;

public class GameHelper {
	private ArrayList<GameObject> objects;
	private ArrayList<Enemy> enemies;

	public GameHelper(ArrayList<GameObject> o, ArrayList<Enemy> e) {


		this.objects = o;
		this.enemies = e;
		
		
	}
}
