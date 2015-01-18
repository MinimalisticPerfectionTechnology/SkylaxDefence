package game;

import gameObjects.Drone;
import gameObjects.Enemy;
import gameObjects.MiniGun;
import gameObjects.Tank;
import gameObjects.GameObject;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;

import actions.ActionHandler;
import actions.UserInput;

public class Game {
	
	public static ArrayList<GameObject> objectsToAdd;
	
	private static ArrayList<GameObject> objects;
	public static ArrayList<Enemy> enemys;
	private ArrayList<ActionHandler> actions;

	public Game() {
		objectsToAdd = new ArrayList<GameObject>();
		objects = new ArrayList<GameObject>();
		actions = new ArrayList<ActionHandler>();
		enemys = new ArrayList<Enemy>();
		// GOShot shot = new GOShot(Display.getWidth() / 2 - GOShot.SIZE / 2,
		// Display.getHeight() / 2 - GOShot.SIZE / 2);
		// objects.add(shot);

		/*
		 * joppe was here:
		 */

		Drone drone1 = new Drone(50, 50, 20, 20);
		enemys.add(drone1);
		objects.add(drone1);

		Drone drone2 = new Drone(200, 40, 60, 60);
		drone2.gotHit();
		drone2.gotHit();
		drone2.gotHit();
		enemys.add(drone2);
		objects.add(drone2);

//		 GODrone drone3 = new GODrone(200, 300, 20, 50);
//		 enemys.add(drone3);
//		 objects.add(drone3);
		
		Tank tank1 = new Tank(600, 5, 80, 80);
		enemys.add(tank1);
		objects.add(tank1);

		// GOTank tank2 = new GOTank(300, 130, 80, 80);
		// enemys.add(tank2);
		// objects.add(tank2);

		MiniGun miniGun1 = new MiniGun(Display.getWidth() - 200, Display.getHeight() / 4);
		objects.add(miniGun1);
		
//		GOMiniGun miniGun2 = new GOMiniGun(Display.getWidth() - 700, Display.getHeight() / 2, enemys);
//		objects.add(miniGun2);
//		
//		GOMiniGun miniGun3 = new GOMiniGun(Display.getWidth() - 400, Display.getHeight() / 6, enemys);
//		objects.add(miniGun3);
//		
//		GOMiniGun miniGun4 = new GOMiniGun(Display.getWidth() - 800, Display.getHeight() - 30, enemys);
//		objects.add(miniGun4);

		// -----------------------------------------------
		UserInput userInput = new UserInput();
		actions.add(userInput);
	}

	public void getInput() {
		for (ActionHandler actionHandler : actions) {
			actionHandler.update();
		}
	}

	public void update() {

		for (Enemy enemy : enemys){
			System.out.println("Enemy health: " + enemy.health);
		}
		System.out.println("______________________________________________________________________");

		for (Iterator<Enemy> iterator = enemys.iterator(); iterator.hasNext();) {
			System.out.println("iterator");
			Enemy enemy = iterator.next();
			if (enemy.health <= 0){
				// Remove the current element from the iterator and the list.
				objects.remove(enemy);
				iterator.remove();
			}
		}

		for (GameObject gameObject : objects) {
			gameObject.update();
		}
		
		objects.addAll(objectsToAdd);
		objectsToAdd.remove(objectsToAdd);
	}

	public void render() {
		// Draw.background();
		for (GameObject gameObject : objects) {
			gameObject.render();
		}
	}
}
