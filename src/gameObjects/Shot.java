package gameObjects;

import game.Physics;

public class Shot extends GameObject {

	
	public static float SHOT_VELOSITY = 10;
	private Physics physics = new Physics();
	
	public static final float R = 0.5f;
	public static final float G = 0.5f;
	public static final float B = 0.5f;
	public static final int SIZE = 7;
	public static final int MAX_SPEEDX = 2;
	public static final int MAX_SPEEDY = 8;

	public int velosity = 10;
//	public int velosityY;
	private double angle;

	public Shot(float x, float y, float dx, float dy) {

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = SIZE;
		this.sy = SIZE;
		this.angle = angle;
		this.dx = dx;
		this.dy = dy;
		
		

//		velosityX = -MAX_SPEEDX;
//		velosityY = 1;
	}

	@Override
	public void update() {
		
		x += dx * SHOT_VELOSITY;
		y += dy * SHOT_VELOSITY;
		for(Enemy enemy : game.Game.enemys) {
			if(physics.checkCollisions(this, enemy)) {
				enemy.gotHit();
			}
		}
//		x += velosityX;
//		y += velosityY;
	}
}
