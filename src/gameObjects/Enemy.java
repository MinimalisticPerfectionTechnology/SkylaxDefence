package gameObjects;

public class Enemy extends GameObject implements Comparable<Enemy> {

	public int health;
	public int speed;

	public Enemy(float x, float y, float sx, float sy) {

		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
	}

	public int getHealth() {
		return health;
	}

	public void gotHit() {
	}

	public void gotDestroyed() {
	}

	@Override
	public void update() {
		this.x += speed;
		this.y += speed;
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
