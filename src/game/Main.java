package game; 

import static gameObjects.Draw.initDisplay;
import static gameObjects.Draw.initGL;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Main {
	private static Game game;

	public static void main(String []args){
		initDisplay();
		initGL();
		
		initGame();
		gameLoop();
		
		cleanUp();
	}

	private static void initGame() {
		game = new Game();
	}

	private static void getInput() {
		game.getInput();
	}

	private static void update() {
		game.update();
	}

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
//		glLoadIdentity();
		game.render();

		Display.update();
		Display.sync(60);
	}

	private static void gameLoop(){
		while (!Display.isCloseRequested()){
			getInput();
			update();
			render();
		}
	}

	private static void cleanUp(){
		Display.destroy();
		Keyboard.destroy();
	}
}
