package gameObjects;

import java.util.ArrayList;

public class RocketLauncher extends Tower {

	public static final float R = 1f;
	public static final float G = 1f;
	public static final float B = 1f;

	public RocketLauncher(float x, float y, ArrayList<Enemy>enemys) {
		super(x, y, enemys);
		this.range = 600;
		this.damege = 100;
		this.fireRate = 5;

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = 40;
		this.sy = 40;
		// INTERVAL = 3;
	}

	// @Override
	// public void update() {
	//
	//
	// }
}
