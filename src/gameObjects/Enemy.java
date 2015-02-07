package gameObjects;

import game.Game;

public class Enemy extends GameObject implements Comparable<Enemy>{

	public int health;
	public int speed;

	public int getSpeed() {
		return speed;
	}

	public Enemy(float x, float y, float sx, float sy) {

		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		this.dx = 1;
		this.dy = 1;
	}

	public int getHealth() {
		return health;
	}

	public void gotHit() {
	}

	public void gotDestroyed() {
	}
	private int i = 0;
	@Override
	public void update() {
		
		/*third argument: 1 = came from right, 2 = came
		 * from down, 3 = came from left, 4 = came from up.
		 */
		
		/*
		int k = Game.map.getDirection(x, y, i);
		if(k == 1) {
			dx = -1;
			dy = 0;
			i= 3;
		}
		else if(k == 2) {
			dx = 0;
			dy = 1;
			i= 4;
		}
		else if(k == 3) {
			dx = 1;
			dy = 0;
			i= 1;
		}
		else if(k == 4) {
			dx = 0;
			dy = -1;
			i= 2;
		}
		else {
			dx = 1;
			dy = 1;
		}
		
		*/
		this.x += dx * speed;
		this.y += dy * speed;
		
//		this.x +=  speed;
//		this.y += speed;
	}

	@Override
	public int compareTo(Enemy o) {
		return 0;
	}

	public boolean isInRange(float towerX, float towerY, int range) {
		if (Math.sqrt(((towerX - x) * (towerX - x) + (towerY - y) * (towerY - y))) <= range) {
			return true;
		}
		return false;
	}
}
