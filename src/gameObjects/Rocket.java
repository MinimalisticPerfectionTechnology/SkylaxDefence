package gameObjects;

import game.Physics;

public class Rocket extends Shot{
	public static float SHOT_VELOSITY = 20;

	protected float R = 1f;
	protected float G = 0f;
	protected float B = 0f;
	protected int SIZE = 30;
	
	public Rocket(float x, float y, float dx, float dy) {
		super(x, y, dx, dy);
		red = R;
		green = G;
		blue = B;
		this.width = SIZE;
		this.height = SIZE;
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
}
