package game;

import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.Tower;

import java.util.ArrayList;

public class GameHelper {
	private ArrayList<GameObject> objects;
	private ArrayList<Enemy> enemies;
	private int counter = 0;
	public GameHelper(ArrayList<GameObject> o, ArrayList<Enemy> e) {


		this.objects = o;
		this.enemies = e;
		
		
	}
	
	
	public void act() {
		
		for(GameObject go : objects) {
			if(go instanceof Tower) {
				
			}
		}
		
		counter++;
	}
}
