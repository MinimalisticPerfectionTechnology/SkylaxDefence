package actions;

import game.Game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
public class UserInput extends ActionHandler{

	/*
	 * User input gets a Game so
	 * that it can then the inputs
	 * to a class that holds all
	 * of the objects, because they can
	 * all be affected by the input.
	 */
	
	private Game game;

	public UserInput(Game game){
		this.game = game;
	}

	//	public void getInput(){
	//		System.out.println("get input!!!");
	//		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
	//			Display.destroy();
	//			System.exit(0);
	//			System.out.println("Nånting händer :D");
	//		}
	//	}

	public void update() {
		while(Mouse.next()){
			if (Mouse.getEventButtonState()){
				if(Mouse.getEventButton() == 0){
					System.out.println("VÄNSTER KLICK");
					
					/*
					 * first it call the Input
					 * method of game, just saying
					 * "i clicked here"
					 */
					game.setInput("leftClick", Mouse.getX(), Mouse.getY());
				}
				if(Mouse.getEventButton() == 1){
					System.out.println("HÖGER KLICK");
				}
			} else{
				if(Mouse.getEventButton() == 0){
					System.out.println("VÄNSTER SLÄPP");
				}
				if(Mouse.getEventButton() == 1){
					System.out.println("HÖGER SLÄPP");
				}
			} if(Mouse.isButtonDown(0)) {
				/*
				 * then it keeps saying
				 * where the mouse x and y
				 * is, "now passing the string "leftDown"
				 * instead.
				 */
				
				game.setInput("leftDown", Mouse.getX(), Mouse.getY());
			}
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			System.out.println("X = " + Mouse.getX() + "\tY = " + Mouse.getY());
		}

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					System.out.println("A Key Pressed");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S) {
					System.out.println("S Key Pressed");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
					System.out.println("D Key Pressed");
				}
			} else {
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					System.out.println("A Key Released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S) {
					System.out.println("S Key Released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
					System.out.println("D Key Released");
				}
			}
		}
	}
}
