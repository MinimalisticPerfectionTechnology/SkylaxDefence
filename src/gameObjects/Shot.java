package gameObjects;

import game.Physics;

public abstract class Shot extends GameObject {	

//	public static final int MAX_SPEEDX = 2;
//	public static final int MAX_SPEEDY = 8;

	private double angle;
	protected boolean destroyMe = false;

	public Shot(float x, float y, float dx, float dy) {


		this.x = x;
		this.y = y;

		//this.angle = angle;
		this.dx = dx;
		this.dy = dy;
		
		

//		velosityX = -MAX_SPEEDX;
//		velosityY = 1;
	}

	public boolean isDestroyMe() {
		// TODO Auto-generated method stub
		return destroyMe;
	}
}
