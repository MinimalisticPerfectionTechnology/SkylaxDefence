package game;

import gameObjects.Drone;
import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.MiniGun;
import gameObjects.Shot;
import gameObjects.Tank;
import gameObjects.Tower;
import helpers.Draw;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import actions.ActionHandler;
import actions.UserInput;

public class Game {
	public static Texture texture;
	public static ArrayList<GameObject> objectsToAdd;
	public static ArrayList<Enemy> enemiesToAdd;
	
	private static ArrayList<GameObject> objects;
	public static ArrayList<Enemy> enemys;
	private ArrayList<ActionHandler> actions;

	public Game() {
		objectsToAdd = new ArrayList<GameObject>();
		enemiesToAdd = new ArrayList<Enemy>();
		objects = new ArrayList<GameObject>();
		actions = new ArrayList<ActionHandler>();
		enemys = new ArrayList<Enemy>();
		
		// GOShot shot = new GOShot(Display.getWidth() / 2 - GOShot.SIZE / 2,
		// Display.getHeight() / 2 - GOShot.SIZE / 2);
		// objects.add(shot);
		
		texture = Draw.createTile(true);
		
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
		
		
		/*
		MiniGun miniGun2 = new MiniGun(Display.getWidth() - 700, Display.getHeight() / 2);
		objects.add(miniGun2);
		*/
//		
//		GOMiniGun miniGun3 = new GOMiniGun(Display.getWidth() - 400, Display.getHeight() / 6, enemys);
//		objects.add(miniGun3);
//		
//		GOMiniGun miniGun4 = new GOMiniGun(Display.getWidth() - 800, Display.getHeight() - 30, enemys);
//		objects.add(miniGun4);

		// -----------------------------------------------
		UserInput userInput = new UserInput(this);
		actions.add(userInput);
	}

	public void getInput() {
		for (ActionHandler actionHandler : actions) {
			actionHandler.update();
		}
	}
	int bool = 0;
	public void update() {

		
		
		
		
		for (Enemy enemy : enemys){
			System.out.println("Enemy health: " + enemy.health);
		}
		
		
		
		
		
//		System.out.println("______________________________________________________________________");

		
		Enemy enemyLocal = null;
		
		for (Iterator<Enemy> iterator = enemys.iterator(); iterator.hasNext();) {
//			System.out.println("iterator");
			Enemy enemy = iterator.next();
			if (enemy.health <= 0 || (enemy.getX() < 0 || enemy.getX() > Draw.WIDTH || enemy.getY() < 0 || enemy.getY() > Draw.HEIGHT)){
				// Remove the current element from the iterator and the list.
				objects.remove(enemy);
				iterator.remove();
				if(bool == 0){
				enemyLocal = new Drone((float) (Math.random()*Draw.WIDTH), 40, 20, 20);
				bool = 1;
				}
				else {
					enemyLocal = new Tank((float) (Math.random()*Draw.WIDTH), 5, 80, 80);
					bool = 0;
				}
				objectsToAdd.add(enemyLocal);
				enemiesToAdd.add(enemyLocal);
				
			}

		}

		for (Iterator<GameObject> iterator = objects.iterator(); iterator.hasNext();) {
			GameObject o = iterator.next();
			o.update();
			if (o instanceof Shot) {
				
				if(((Shot) o).isDestroyMe()) {
					iterator.remove();
				}
			}
			if((o.getX() < 0 || o.getX() > Draw.WIDTH || o.getY() < 0 || o.getY() > Draw.HEIGHT) && iterator.hasNext()) {
				iterator.remove();
			}
			
		}
		enemys.addAll(enemiesToAdd);
		objects.addAll(objectsToAdd);
		objectsToAdd.clear();
		enemiesToAdd.clear();
	}

	public void render() {
		// Draw.background();
		Draw.DrawQuadTex(texture, 0, 0, 64, 64);
		for (GameObject gameObject : objects) {
			gameObject.render();
		}
	}
	
	/*
	 * we only want to iterate trough
	 * the towers once, when the mouse is clicked
	 * , and tell they "now the mouse was clicked,
	 * please let me know if i hit you or not
	 * (check out the setIsGRabbed-method, which
	 * is boolean and gives back if it was hit or not.
	 * Right so we create a tower that can be referred 
	 * to later when we move the mouse.
	 */
	
	Tower t =null;
	public void setInput(String kind, float x, float y) {
		
		switch (kind) {
		
		case "leftClick":
			for(GameObject o : objects) {
				if( o instanceof Tower) {
					if(((Tower) o).setIsGrabbed(x, y)) {
						t = ((Tower) o);
						break;
					}
				}
			}
		
		case "leftDown":
			if(t != null) t.setIsGrabbedMoved(x, y);
		
			break;
		case "leftRelease":
			t.release();
		}
	}
}
