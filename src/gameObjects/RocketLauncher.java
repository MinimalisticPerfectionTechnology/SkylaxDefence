package gameObjects;

public class RocketLauncher extends Tower {

	public static final float R = 1f;
	public static final float G = 1f;
	public static final float B = 1f;

	public RocketLauncher(float x, float y) {
		super(x, y);
		this.range = 600;
		this.damege = 100;
		this.fireRate = 5;

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = 40;
		this.sy = 40;
		// INTERVAL = 3;
	}

	@Override
	protected void shoot(Enemy enemy) {


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

		// @Override
		// public void update() {
		//
		//
		// }
	}
}
