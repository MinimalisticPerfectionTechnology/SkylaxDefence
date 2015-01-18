package gameObjects;

public class Shot extends GameObject {

	public static final float R = 0.5f;
	public static final float G = 0.5f;
	public static final float B = 0.5f;
	public static final int SIZE = 7;
	public static final int MAX_SPEEDX = 2;
	public static final int MAX_SPEEDY = 8;

	public int velosity = 1;
//	public int velosityY;
	private double angle;

	public Shot(float x, float y, double angle) {

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = SIZE;
		this.sy = SIZE;
		this.angle = angle;

//		velosityX = -MAX_SPEEDX;
//		velosityY = 1;
	}

	@Override
	public void update() {
		
		x += Math.cos(angle)*velosity;
		y += Math.sin(angle)*velosity;
		
//		x += velosityX;
//		y += velosityY;
	}
}
