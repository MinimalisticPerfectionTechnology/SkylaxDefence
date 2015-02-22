package gameObjects;

import game.Physics;
import helpers.Draw;

public class MiniGunBullet extends Shot{
	public static float SHOT_VELOSITY = 40;

	protected float R = 0.4f;
	protected float G  = 0.4f;
	protected float B  = 0.4f;
	protected int RADIUS = 10;
	protected int damage;
	
	public MiniGunBullet(float x, float y, float dx, float dy, int damage) {
		super(x, y, dx, dy);
		red = R;
		green = G;
		blue = B;
		this.radius = RADIUS;
		this.damage = damage;
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
				enemy.gotHit(damage);
				destroyMe = true;
			}
		}
//		x += velosityX;
//		y += velosityY;
	}
	
	@Override
	public void render(){
//		Draw.rect(red, green, blue, x, y, width, height);
		Draw.circle(red, green, blue, radius);
	}
}
