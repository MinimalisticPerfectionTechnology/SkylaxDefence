package gameObjects;

public class MiniGun extends Tower {

	public static final float R = 0.4f;
	public static final float G = 0.4f;
	public static final float B = 0.4f;

	//	public int velosityX;
	//	public int velosityY;


	public MiniGun(float x, float y) {
		super(x, y);
		this.range = 500;
		this.damege = 2;
		this.fireRate = 10;

		red = R;
		green = G;
		blue = B;
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 40;
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

			float[] enemyWillBeAt = getNewEnemyCoordinates(enemy, MiniGunBullet.SHOT_VELOSITY);

			float[] d = getInternarShotSpeed(x, y, enemyWillBeAt[0], enemyWillBeAt[1]);

			game.Game.objectsToAdd.add(new MiniGunBullet(x, y, d[0], d[1]));	//TODO next step: use SHOT_VELOSITY

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
