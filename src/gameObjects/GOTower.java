package gameObjects;

import helpers.Enums.Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GOTower extends GameObject implements shootable{

	protected int range;
	protected int damege;
	protected int fireRate;
	public int velosityX;
	public int velosityY;
	public Priority priority;
//	private boolean isShooting = false;

	public Priority getPriority() {
		return priority;
	}
	protected ArrayList<GOEnemy> enemysInRange;
	private int counter = 0;

	// protected int INTERVAL;

	public GOTower(float x, float y) {
		this.x = x;
		this.y = y;
		sx = 40;
		sy = 40;
		enemysInRange = new ArrayList<GOEnemy>();
		//		priority = Priority.FIRST;
		priority = Priority.STRONG;
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
		for(GOEnemy enemy : game.Game.enemys){
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
	public GOEnemy aim() {
		if(!enemysInRange.isEmpty()){
			switch (priority) {

			case FIRST:
				System.out.println("Priority is: FIRST");
				return enemysInRange.get(0);

			case LAST:
				System.out.println("Priority is: LAST");

			case STRONG:
				System.out.println("Priority is: STRONG");

				Collections.sort(enemysInRange, new Comparator<GOEnemy>() {
					public int compare(GOEnemy o1, GOEnemy o2){
						return Integer.compare(o1.getHealth(), o2.getHealth());
					}
				});
				System.out.println(Collections.min(enemysInRange).getHealth());
//				int i = 1;
//				for(GOEnemy thisEnemy : enemys){
//					System.out.println("Enemy " + i + " health: " + thisEnemy.getHealth());
//					i ++;
//				}
				return Collections.max(enemysInRange);

			case WEAK:
				System.out.println("Priority is: WEAK");

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
	public boolean shoot(GOEnemy enemy) {
		if(!(enemy == null)){
			System.out.println("I shoooot! at an enemy at x: " + enemy.getX());
			enemy.gotHit();
			if(enemy.health <= 0){
				enemy.gotDestroyed();
				
//				enemysInRange.remove(enemy);
//				enemy = null;
			}
		}
		return true;
	}

	@Override
	public void hit() {
	}
}
