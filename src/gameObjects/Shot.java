package gameObjects;

import game.Physics;

public class Shot extends GameObject {

	
	public static float SHOT_VELOSITY = 30;

	protected float R = 0.4f;
	protected float G  = 0.4f;
	protected float B  = 0.4f;
	protected int SIZE = 13;
//	public static final int MAX_SPEEDX = 2;
//	public static final int MAX_SPEEDY = 8;

	private double angle;
	private boolean destroyMe = false;

	public Shot(float x, float y, float dx, float dy) {

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = SIZE;
		this.sy = SIZE;
		//this.angle = angle;
		this.dx = dx;
		this.dy = dy;
		
		

//		velosityX = -MAX_SPEEDX;
//		velosityY = 1;
	}

	@Override
	public void update() {
		
		/*
		 * 
		 *this runs!!!! I think it's not printed out
		 *because we removed static which implies 
		 *that draw can't reach this object. 
		 * */
		
		x += dx * SHOT_VELOSITY;
		y += dy * SHOT_VELOSITY;
		
		for(Enemy enemy : game.Game.enemys) {
			if(Physics.checkCollisions(this, enemy)) {
				enemy.gotHit();
				destroyMe = true;
			}
		}
//		x += velosityX;
//		y += velosityY;
	}


	public boolean isDestroyMe() {
		// TODO Auto-generated method stub
		return destroyMe;
	}
}
