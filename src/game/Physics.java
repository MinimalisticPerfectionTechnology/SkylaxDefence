package game;

import gameObjects.GameObject;
import helpers.Draw;

import java.awt.Rectangle;
//import java.io.ObjectInputStream.GetField;
//import java.nio.ReadOnlyBufferException;


public class Physics {
	public static boolean checkCollisions(GameObject go1, GameObject go2){
		Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getY(), (int)go1.getWidth(), (int)go1.getHeight());
		Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getY(), (int)go2.getWidth(), (int)go2.getHeight());
		return r1.intersects(r2);

	}
	
	public static boolean checkCollectionCoordinates(GameObject go, float x, float y) {
		Rectangle r = new Rectangle((int)go.getX(), (int)go.getY(), (int)go.getWidth(), (int)go.getHeight());
		
		return r.intersects(x, y, r.getWidth(), r.getHeight());
	}
	public static boolean hasLeftScreen(GameObject o) {
		if(o.getX() < 0 || o.getX() > Draw.WIDTH || o.getY() < 0 || o.getY() > Draw.HEIGHT) {
			return true;
		}
		return false;
	}
}
