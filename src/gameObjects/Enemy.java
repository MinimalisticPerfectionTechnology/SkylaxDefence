package gameObjects;

import game.Game;

public abstract class Enemy extends GameObject implements Comparable<Enemy>{

	public int health;
	public float speed;

	public float getSpeed() {
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
	private String cameFrom = "LEFT";
	private String direction = "RIGHT";
	@Override
	public void update() {
		
		/*third argument: 1 = came from right, 2 = came
		 * from down, 3 = came from left, 4 = came from up.
		 */
		
		direction = Game.map.getDirection(x, y, cameFrom, direction);
		if(direction == "LEFT") {
			dx = -1;
			dy = 0;
			cameFrom= "RIGTH";
			y = Game.map.snapToY(y);
		}
		else if(direction == "RIGTH") {
			dx = 1;
			dy = 0;
			cameFrom= "LEFT";
			y = Game.map.snapToY(y);
		}
		else if(direction == "DOWN") {
			dx = 0;
			dy = -1;
			cameFrom= "UP";
			x = Game.map.snapToX(x);
		}

		else if(direction == "UP") {
			dx = 0;
			dy = 1;
			cameFrom= "DOWN";
			x = Game.map.snapToX(x);
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
