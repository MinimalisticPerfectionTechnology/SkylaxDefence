package gameObjects;

public class GOShot extends GameObject {

	public static final float R = 0f;
	public static final float G = 1f;
	public static final float B = 0f;
	public static final int SIZE = 40;
	public static final int MAX_SPEEDX = 2;
	public static final int MAX_SPEEDY = 8;

	public int velosityX;
	public int velosityY;

	public GOShot(float x, float y) {

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = SIZE;
		this.sy = SIZE;

		velosityX = -MAX_SPEEDX;
		velosityY = 1;
	}

	@Override
	public void update() {
		x += velosityX;
		y += velosityY;
	}
}
