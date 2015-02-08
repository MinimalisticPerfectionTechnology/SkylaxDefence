package gameObjects;

public class LazerCannon extends Tower {

	public static final float R = 1f;
	public static final float G = 1f;
	public static final float B = 1f;

	public LazerCannon(float x, float y) {
		super(x, y);
		this.range = 600;
		this.damege = 100;
		this.fireRate = 5;

		red = R;
		green = G;
		blue = B;
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 40;
		// INTERVAL = 3;
	}

	@Override
	protected void shoot() {
		
	}

	// @Override
	// public void update() {
	//
	//
	// }
}
