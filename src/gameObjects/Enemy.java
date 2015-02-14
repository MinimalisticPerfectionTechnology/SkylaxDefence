package gameObjects;

import game.Game;

public abstract class Enemy extends GameObject implements Comparable<Enemy>{

	public int health;
	public int speed;

	public int getSpeed() {
		return speed;
	}

	public Enemy(float x, float y, float width, float height) {

		this.x = x;
		this.y = y;
		this.width= width;
		this.height = height;
		this.dx = 1;
		this.dy = 1;
	}

	public int getHealth() {
		return health;
	}

	public void gotHit(int damegeTaken) {
		health -= damegeTaken;
	}

	public void gotDestroyed() {
	}
	private int i = 2;
	private int k = 4;
	@Override
	public void update() {
		
		/*third argument: 1 = came from right, 2 = came
		 * from down, 3 = came from left, 4 = came from up.
		 */
		k = Game.map.getDirection(x, y, i, k);
		if(k == 1) {
			dx = -1;
			dy = 0;
			i= 3;
			y = Game.map.snapToY(y);
		}
		else if(k == 2) {
			dx = 0;
			dy = 1;
			i= 4;
			x = Game.map.snapToX(x);
		}
		else if(k == 3) {
			dx = 1;
			dy = 0;
			i= 1;
			y = Game.map.snapToY(y);
		}
		else if(k == 4) {
			dx = 0;
			dy = 1;
			i= 2;
			x = Game.map.snapToX(x);
		}
		else {
			dx = 1;
			dy = 1;

		}
		
		
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
