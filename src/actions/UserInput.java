package actions;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
public class UserInput extends ActionHandler{

	public UserInput(){
	}

	//	public void getInput(){
	//		System.out.println("get input!!!");
	//		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
	//			Display.destroy();
	//			System.exit(0);
	//			System.out.println("N�nting h�nder :D");
	//		}
	//	}

	public void update() {
		while(Mouse.next()){
			if (Mouse.getEventButtonState()){
				if(Mouse.getEventButton() == 0){
					System.out.println("V�NSTER KLICK");
				}
				if(Mouse.getEventButton() == 1){
					System.out.println("H�GER KLICK");
				}
			} else{
				if(Mouse.getEventButton() == 0){
					System.out.println("V�NSTER SL�PP");
				}
				if(Mouse.getEventButton() == 1){
					System.out.println("H�GER SL�PP");
				}
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
