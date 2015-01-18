package game;

import gameObjects.GODrone;
import gameObjects.GOEnemy;
import gameObjects.GOMiniGun;
import gameObjects.GOTank;
import gameObjects.GameObject;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;

import actions.ActionHandler;
import actions.UserInput;

public class Game {
	private static ArrayList<GameObject> objects;
	public static ArrayList<GOEnemy> enemys;
	private ArrayList<ActionHandler> actions;

	public Game() {
		objects = new ArrayList<GameObject>();
		actions = new ArrayList<ActionHandler>();
		enemys = new ArrayList<GOEnemy>();
		// GOShot shot = new GOShot(Display.getWidth() / 2 - GOShot.SIZE / 2,
		// Display.getHeight() / 2 - GOShot.SIZE / 2);
		// objects.add(shot);

		/*
		 * joppe was here:
		 */

		GODrone drone1 = new GODrone(50, 50, 20, 20);
		enemys.add(drone1);
		objects.add(drone1);

		GODrone drone2 = new GODrone(200, 40, 60, 60);
		drone2.gotHit();
		drone2.gotHit();
		drone2.gotHit();
		enemys.add(drone2);
		objects.add(drone2);

//		 GODrone drone3 = new GODrone(200, 300, 20, 50);
//		 enemys.add(drone3);
//		 objects.add(drone3);
		
		GOTank tank1 = new GOTank(600, 5, 80, 80);
		enemys.add(tank1);
		objects.add(tank1);

		// GOTank tank2 = new GOTank(300, 130, 80, 80);
		// enemys.add(tank2);
		// objects.add(tank2);

		GOMiniGun miniGun1 = new GOMiniGun(Display.getWidth() - 30, Display.getHeight() / 4);
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

		for (GOEnemy enemy : enemys){
			System.out.println("Enemy health: " + enemy.health);
		}
		System.out.println("______________________________________________________________________");

		for (Iterator<GOEnemy> iterator = enemys.iterator(); iterator.hasNext();) {
			System.out.println("iterator");
			GOEnemy enemy = iterator.next();
			if (enemy.health <= 0){
				// Remove the current element from the iterator and the list.
				objects.remove(enemy);
				iterator.remove();
			}
		}

		for (GameObject gameObject : objects) {
			gameObject.update();
		}
	}

	public void render() {
		// Draw.background();
		for (GameObject gameObject : objects) {
			gameObject.render();
		}
	}
}
