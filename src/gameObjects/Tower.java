package gameObjects;

import game.Physics;
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
	private boolean isGrabbed;

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
//				System.out.println("Priority is: STRONG");

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

			case WEAK:
//				System.out.println("Priority is: WEAK");
				
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
			
//			angle = getAngleToPoint(enemy.getX(), enemy.getY(), x, y);
			
			
			float[] enemyWillBeAt = getNewEnemyCoordinates(enemy);
			
			float[] d = getInternarShotSpeed(x, y, enemyWillBeAt[0], enemyWillBeAt[1]);
			
			game.Game.objectsToAdd.add(new Shot(x, y, d[0], d[1]));	//TODO next step: use SHOT_VELOSITY
			
//			enemy.gotHit();
			if(enemy.health <= 0){
				enemy.gotDestroyed();
				
//				enemysInRange.remove(enemy);
//				enemy = null;
			}
		}
		return true;
	}
	
	/*
	 * this method utpdated the possible
	 * coordinates where the enemy might be the next
	 * iteration. it uses the enemies dx and dy
	 * to se how fast it moved in each direction.
	 * it then calculates the length till the nest point
	 * and sees whether the shot whould be there efter
	 * that certain amont of inerations.
	 */
	
	private float[] getNewEnemyCoordinates(Enemy enemy) {
		
		
		float enemyXMove = enemy.getDx() * enemy.getSpeed();
		float enemyYMove = enemy.getDy() * enemy.getSpeed();
		
		float currentEX = enemy.getX();
		float currentEY = enemy.getY();
		float currentLenght =(float) Math.sqrt((Math.pow(currentEX - this.getX(), 2) + Math.pow(currentEY - this.getY(), 2)));
		
		
		int i = 1;
		while(true) {
			if(currentLenght <= Shot.SHOT_VELOSITY*i) {
				return new float[]{currentEX, currentEY};
			} else {
				currentEX += enemyXMove;
				currentEY += enemyYMove;
				
				currentLenght = (float) Math.sqrt((Math.pow(currentEX - this.getX(), 2) + Math.pow(currentEY - this.getY(), 2)));
				
			}
			
			
			i++;
		}
		

	}
	
	/*
	 * a method I cheched up on google (only to
	 * get the neetes one ;) that returns the
	 * appliccable x+, and y+ normalized.
	 */
	
	private float[] getInternarShotSpeed(float targetX, float targetY, float originX, float originY) {
		float dx = originX - targetX;
		float dy = originY - targetY;
		float norm = (float) Math.sqrt(dx * dx + dy * dy);
		dx *= (1 / norm);
		dy *= (1 / norm);
		return new float[] {dx, dy};
		
		
	}
	
	/*
	private float getAngleToPoint(float targetX, float targetY, float originX, float originY) {
		float currentLengthX = originX- targetX;
		float currentLengthY = originY - targetY;

		return (float) (Math.atan2(currentLengthY, currentLengthX)+(Math.PI));
	}
	*/
	
	/*
	 * if the field isGrabbed is true
	 * then set this entire object
	 * to the coordinates of the mouse.
	 */
	
	private void moveMe(float x, float y) {
		if(isGrabbed) {
		this.x = x;
		this.y = y;
		}
	}
	
	/*
	 * this method recieves the x and y
	 * of the mouse and checks whether it was hit or not
	 * if it was then it gives back the value true
	 * to the general game-class.
	 */
	

	public boolean setIsGrabbed(float x, float y) {
		
		if(Physics.checkCollectionCoordinates(this, x, y)) {
			isGrabbed = true;
			
		} else return false;
		moveMe(x, y);
		return true;
	}
	
	public void release() {
		isGrabbed = false;
	}

	@Override
	public void hit() {
	}

	/*
	 * pretty much the same as above only
	 * that this one does not return anything,
	 * so that it doesnt have to tage reasources
	 * in vain.
	 */
	public void setIsGrabbedMoved(float x, float y) {
		if(Physics.checkCollectionCoordinates(this, x, y)) {
			isGrabbed = true;
			
		}
		moveMe(x, y);
		
	}
}
