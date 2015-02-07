package gameObjects;

import game.Physics;

public class EMPBlast extends Shot{
	public static float SHOT_VELOSITY = 30;

	protected float R = 0.4f;
	protected float G  = 0.4f;
	protected float B  = 0.4f;
	protected int SIZE = 13;
	
	public EMPBlast(float x, float y, float dx, float dy) {
		super(x, y, dx, dy);
		r = R;
		g = G;
		b = B;
		this.sx = SIZE;
		this.sy = SIZE;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update() {	
		for(Enemy enemy : game.Game.enemys) {
			if(Physics.checkCollisions(this, enemy)) {
				enemy.gotHit();
				destroyMe = true;
			}
		}
	}
}
