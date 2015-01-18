package game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import gameObjects.GameObject;

public class Player extends GameObject{
	public static final float SIZE = 32;
	
	public Player(float x, float y){
		
//		init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE);
		
		init(x, y);
	}
	
	public void getInput(){
		if (Keyboard.isKeyDown(Keyboard.KEY_W)){
			System.out.println(" händer det nåt här eller?????????????");
			Display.destroy();
			System.exit(0);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
