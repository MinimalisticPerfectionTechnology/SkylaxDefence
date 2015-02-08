package gameObjects;

import game.Physics;

public class EMPBlast extends Shot{
	public static float SHOT_VELOSITY = 30;

	protected float R = 0f;
	protected float G = 1f;
	protected float B = 1f;
	protected int SIZE = 13;
	protected int damage;
	
	public EMPBlast(float x, float y, int damage) {
		super(x, y, 0, 0);
		red = R;
		green = G;
		blue = B;
		this.width = SIZE;
		this.height = SIZE;
		this.damage = damage;
	}
	
	@Override
	public void update() {
		
		for(Enemy enemy : game.Game.enemys) {
			if(Physics.checkCollisions(this, enemy)) {
				enemy.gotHit(damage);
				destroyMe = true;
			}
		}
	}
}
