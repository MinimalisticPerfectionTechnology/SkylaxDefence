package gameObjects;

import helpers.Draw;

public abstract class Shot extends GameObject {	

//	public static final int MAX_SPEEDX = 2;
//	public static final int MAX_SPEEDY = 8;

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
		return destroyMe;
	}

	@Override
	public void render(){
		Draw.circle(red, green, blue, width, height, 50);
	}
}
