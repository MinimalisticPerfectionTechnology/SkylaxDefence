package gameObjects;

public class RocketLauncher extends Tower {

	public static final float R = 1f;
	public static final float G = 1f;
	public static final float B = 1f;

	public RocketLauncher(float x, float y) {
		super(x, y);
		this.range = 700;
		this.damege = 300;
		this.fireRate = 1;

		red = R;
		green = G;
		blue = B;
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 100;
		// INTERVAL = 3;
	}
	
	@Override
	public void update(){
		prepareForShooting();
	}

	@Override
	protected void shoot() {
		Enemy enemy = selectEnemy();
		if(!(enemy == null)){

			//			angle = getAngleToPoint(enemy.getX(), enemy.getY(), x, y);

			float[] enemyWillBeAt = getNewEnemyCoordinates(enemy, Rocket.SHOT_VELOSITY);

			float[] d = getInternarShotSpeed(x, y, enemyWillBeAt[0], enemyWillBeAt[1]);

			game.Game.objectsToAdd.add(new Rocket(x, y, d[0], d[1]));	//TODO next step: use SHOT_VELOSITY

			//			enemy.gotHit();
			if(enemy.health <= 0){
				enemy.gotDestroyed();

				//				enemysInRange.remove(enemy);
				//				enemy = null;
			}
		}

		// @Override
		// public void update() {
		//
		//
		// }
	}

}
