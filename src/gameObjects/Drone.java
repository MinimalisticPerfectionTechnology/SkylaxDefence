package gameObjects;

public class Drone extends Enemy {
	public Drone(float x, float y, float sx, float sy) {
		super(x, y, sx, sy);

		this.r = 1;
		this.g = 0;
		this.b = 1;
		this.speed = 2;
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
