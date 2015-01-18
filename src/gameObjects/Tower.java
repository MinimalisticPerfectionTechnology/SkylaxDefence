package gameObjects;

import helpers.Enums.Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tower extends GameObject implements shootable{

	protected int range;
	protected int damege;
	protected int fireRate;
	public int velosityX;
	public int velosityY;
	public Priority priority;
	
	
	private float angle;
	
//	private boolean isShooting = false;

	public Priority getPriority() {
		return priority;
	}
	protected ArrayList<Enemy> enemysInRange;
	private int counter = 0;

	// protected int INTERVAL;

	public Tower(float x, float y) {
		this.x = x;
		this.y = y;
		sx = 40;
		sy = 40;
		enemysInRange = new ArrayList<Enemy>();
		//		priority = Priority.FIRST;
		priority = Priority.WEAK;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	// public void setEnemy(GOEnemy e) {
	// this.enemy = e;
	// }

	@Override
	public void update() {
		enemysInRange.clear();
		for(Enemy enemy : game.Game.enemys){
			if(enemy.isInRange(x, y, range)){
			enemysInRange.add(enemy);
			}
		}
		
		
//				System.out.println(isShooting ? "Is shooting" : "Not shooting");
//		 isShooting? shoot(aim()): System.out.println("skjuter redan");
		if (counter % (60 / fireRate) == 0) {
			shoot(aim());
		} else if (counter > (60 / fireRate)) {
			counter = 0;
		}
		counter++;
		
	}

	@Override
	public Enemy aim() {
		if(!enemysInRange.isEmpty()){
			switch (priority) {

			case FIRST:
				System.out.println("Priority is: FIRST");
				return enemysInRange.get(0);

			case LAST:
				System.out.println("Priority is: LAST");

			case STRONG:
				System.out.println("Priority is: STRONG");

				Collections.sort(enemysInRange, new Comparator<Enemy>() {
					public int compare(Enemy o1, Enemy o2){
						return Integer.compare(o1.getHealth(), o2.getHealth());
					}
				});
				System.out.println(Collections.min(enemysInRange).getHealth());
//				int i = 1;
//				for(GOEnemy thisEnemy : enemys){
//					System.out.println("Enemy " + i + " health: " + thisEnemy.getHealth());
//					i ++;
//				}
				
				return enemysInRange.get(enemysInRange.size()-1);
//				return Collections.max(enemysInRange);

			case WEAK:
				System.out.println("Priority is: WEAK");
				
				Collections.sort(enemysInRange, new Comparator<Enemy>() {
					public int compare(Enemy o1, Enemy o2){
						return Integer.compare(o1.getHealth(), o2.getHealth());
					}
				});
				return enemysInRange.get(0);

			case FAST:
				System.out.println("Priority is: FAST");

			case SLOW:
				System.out.println("Priority is: SLOW");
			}
		}
		
		// return enemys.get(0);
		return null;
	}

	@Override
	public boolean shoot(Enemy enemy) {
		if(!(enemy == null)){
			
			angle = getAngleToPoint(enemy.getX(), enemy.getY(), x, y);
			
			game.Game.objectsToAdd.add(new Shot(x, y, angle));
			
			enemy.gotHit();
			if(enemy.health <= 0){
				enemy.gotDestroyed();
				
//				enemysInRange.remove(enemy);
//				enemy = null;
			}
		}
		return true;
	}
	
	
	
	private float getAngleToPoint(float targetX, float targetY, float originX, float originY) {
		float currentLengthX = originX- targetX;
		float currentLengthY = originY - targetY;

		return (float) (Math.atan2(currentLengthY, currentLengthX)+(Math.PI));
	}
	
	
	

	@Override
	public void hit() {
	}
}