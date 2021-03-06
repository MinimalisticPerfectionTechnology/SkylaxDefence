package game;

import gameObjects.Drone;
import gameObjects.EMPBlast;
import gameObjects.EMPGenerator;
import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.Map;
import gameObjects.MiniGun;
import gameObjects.RocketLauncher;
import gameObjects.Shot;
import gameObjects.Tank;
import gameObjects.Tower;
import helpers.Draw;
import helpers.Tile;
import helpers.TileGrid;
import helpers.TileType;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import actions.ActionHandler;
import actions.UserInput;

public class Game {
	private final int startX = 500;
	private final int startY = 110;
	public static Map map = null;
	public static Tile[][] tiles;
	public static Texture grass;
	public static Texture dirt;
	private TileGrid tileGrid;
//	public static ArrayList<Tile> tiles;
	public static ArrayList<GameObject> objectsToAdd;
	public static ArrayList<Enemy> enemiesToAdd;
	
	private static ArrayList<GameObject> objects;
	public static ArrayList<Enemy> enemys;
	private ArrayList<ActionHandler> actions;

	public Game() {
//		tiles = new ArrayList<Tile>();
		Draw.rect(1, 0, 1, 300, 300, 30, 30);
		Draw.rect(1, 1, 1, 20, 20, 400, 400);
		Draw.rect(1, 0, 1, 200, 200, 40, 40);
		
		Draw.circle(1, 1, 0, 200, 200, 30);
		
		map = new Map();
		tiles = new Tile[10][15];
		objectsToAdd = new ArrayList<GameObject>();
		enemiesToAdd = new ArrayList<Enemy>();
		objects = new ArrayList<GameObject>();
		actions = new ArrayList<ActionHandler>();
		enemys = new ArrayList<Enemy>();
		
		// GOShot shot = new GOShot(Display.getWidth() / 2 - GOShot.SIZE / 2,
		// Display.getHeight() / 2 - GOShot.SIZE / 2);
		// objects.add(shot);
		
		grass = Draw.createTexture(true);
		dirt = Draw.createTexture(false);
		
		tileGrid = new TileGrid();
//		for(int i = 0; i < 10; i++){
//			for(int ii = 0; ii < 15; ii++){
//				tiles[i][ii] = Tile;
//			}
//		}
//		Tile grass = new Tile(0, 0, 64, 64, a Tile or something);
//		tiles[0][0] = grass;
//		tiles[1][0] = grass;
//		tiles[2][0] = grass;

//		Tile dirt = new Tile(65, 0, 64, 64, TileType.Dirt);
//		tiles[0][1] = (dirt);

		Drone drone1 = new Drone(startX, startY, 20, 20);
		enemys.add(drone1);
		objects.add(drone1); 

		Drone drone2 = new Drone(startX, startY, 60, 60);
		drone2.gotHit(15);
		enemys.add(drone2);
		objects.add(drone2);

//		 GODrone drone3 = new GODrone(200, 300, 20, 50);
//		 enemys.add(drone3);
//		 objects.add(drone3);
		
		Tank tank1 = new Tank(startX, startY, 80, 80);
		enemys.add(tank1);
		objects.add(tank1);

		// GOTank tank2 = new GOTank(300, 130, 80, 80);
		// enemys.add(tank2);
		// objects.add(tank2);

		MiniGun miniGun1 = new MiniGun(Display.getWidth() - 200, Display.getHeight() / 4);
		objects.add(miniGun1);
		
		
		
		MiniGun miniGun2 = new MiniGun(Display.getWidth() - 700, Display.getHeight() / 2);
		objects.add(miniGun2);
		
		RocketLauncher rocketLauncher1 = new RocketLauncher(Display.getWidth()/4, Display.getHeight()/4);
		objects.add(rocketLauncher1);
		
		EMPGenerator empGenerator = new EMPGenerator(Display.getWidth()/2, Display.getHeight()/2);
		objects.add(empGenerator);
		
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
			//System.out.println("Enemy health: " + enemy.health);
		}
		
		
		
		
		
//		System.out.println("______________________________________________________________________");

		
		Enemy enemyLocal = null;
		
		for (Iterator<Enemy> iterator = enemys.iterator(); iterator.hasNext();) {
//			System.out.println("iterator");
			Enemy enemy = iterator.next();
			if (enemy.health <= 0 || Physics.hasLeftScreen(enemy)){
				// Remove the current element from the iterator and the list.
				objects.remove(enemy);
				iterator.remove();
				if(bool == 0){
				enemyLocal = new Drone(startX,startY, 20, 20);
				bool = 1;
				}
				else {
					enemyLocal = new Tank(startX, startY, 80, 80);
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
			if(Physics.hasLeftScreen(o) && iterator.hasNext()) {
				iterator.remove();			//FIXME can't remove if a shot is on its way to it
			}
			
		}
		enemys.addAll(enemiesToAdd);
		objects.addAll(objectsToAdd);
		objectsToAdd.clear();
		enemiesToAdd.clear();
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

	public void render() {
		// Draw.background();
		
		tileGrid.draw();
		/*
		Draw.DrawQuadTex(grass, 0, 0, 64, 64);
		Draw.DrawQuadTex(grass, 64, 0, 64, 64);
		Draw.DrawQuadTex(grass, 128, 0, 64, 64);
		Draw.DrawQuadTex(grass, 192, 0, 64, 64);
		Draw.DrawQuadTex(dirt, 0, 64, 64, 64);
		Draw.DrawQuadTex(dirt, 64, 64, 64, 64);
		Draw.DrawQuadTex(dirt, 128, 64, 64, 64);
		
		 Draw.DrawQuadTex(dirt, 0, 128, 64, 64);
		Draw.DrawQuadTex(dirt, 64, 128, 64, 64);

		Draw.DrawQuadTex(dirt, 0, 192, 64, 64);

		*/
		
//		for(int i = 0; i < 10; i++){
//			for(int ii = 0; ii < 15; ii++){
//				Draw.DrawQuadTex(tiles[i][ii].getTexture(), tiles[i][ii].getX(), tiles[i][ii].getY(), tiles[i][ii].getWidth(), tiles[i][ii].getHeight());
//			}
//		}			

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
