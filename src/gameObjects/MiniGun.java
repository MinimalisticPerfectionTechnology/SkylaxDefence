package gameObjects;

public class MiniGun extends Tower {

	public static final float R = 0.4f;
	public static final float G = 0.4f;
	public static final float B = 0.4f;

	// int range = 20;
	// int damege = 10;
	// int fireRate = 3;

	public int velosityX;
	public int velosityY;

	public MiniGun(float x, float y) {
		super(x, y);
		this.range = 500;
		this.damege = 1;
		this.fireRate = 1;

		r = R;
		g = G;
		b = B;
		this.x = x;
		this.y = y;
		this.sx = 40;
		this.sy = 40;
		// INTERVAL = 3;
	}

	protected void hitTarget() {

		// TODO Auto-generated method stub

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