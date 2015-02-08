package gameObjects;

public class Tank extends Enemy{
	public Tank(float x, float y, float sx, float sy) {
		super(x, y, sx, sy);

		this.red = 0;
		this.green = 1;
		this.blue = 0;
		this.speed = 1;
		health = 200;

	}

	public void gotHit() {
//		System.out.println("The tank got hit!");
		health -=28;
	}
	
	@Override
	public void gotDestroyed() {
//		System.out.println("The tank got destroyed!");
	}
}
