package gameObjects;

public class Drone extends Enemy {
	public Drone(float x, float y, float sx, float sy) {
		super(x, y, sx, sy);

		this.red = 1;
		this.green = 0;
		this.blue = 1;
		this.speed = 1;
		health = 100;

	}

	public void gotHit() {
		System.out.println("The drone got hit!");
		health -=20;
	}

	@Override
	public void gotDestroyed() {
		System.out.println("The drone got destroyed!");
	}
}
