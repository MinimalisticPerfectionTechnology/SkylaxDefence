package gameObjects;

import java.util.ArrayList;

public class MiniGun extends Tower {

	public static final float R = 0.4f;
	public static final float G = 0.4f;
	public static final float B = 0.4f;

	// int range = 20;
	// int damege = 10;
	// int fireRate = 3;

	public int velosityX;
	public int velosityY;

	public MiniGun(float x, float y, ArrayList<Enemy>enemys) {
		super(x, y, enemys);
		this.range = 500;
		this.damege = 1;
		this.fireRate = 10;

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
