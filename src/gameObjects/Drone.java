package gameObjects;

public class Drone extends Enemy {
	public Drone(float x, float y, float width, float height) {
		super(x, y, width, height);

		this.red = 1;
		this.green = 0;
		this.blue = 1;
		this.speed = 0.2f;
		health = 100;

	}

	public void gotHit() {
		//System.out.println("The drone got hit!");
		health -=20;
	}

	@Override
	public void gotDestroyed() {
		//System.out.println("The drone got destroyed!");
	}
}
