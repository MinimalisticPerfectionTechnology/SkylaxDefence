package gameObjects;

public class Drone extends Enemy {
	public Drone(float x, float y, float width, float height) {
		super(x, y, width, height);

		this.red = 1;
		this.green = 0;
		this.blue = 1;
		this.speed = 1;
		health = 100;

	}
}
