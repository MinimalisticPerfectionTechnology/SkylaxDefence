package gameObjects;

public class EMPGenerator extends Tower{
	
	public static final float R = 0f;
	public static final float G = 1f;
	public static final float B = 1f;
	
	public EMPGenerator(float x, float y) {
		super(x, y);
		this.range = 700;
		this.damage = 300;
		this.fireRate = 1;

		red = R;
		green = G;
		blue = B;
		this.x = x;
		this.y = y;
		this.width = 60;
		this.height = 60;
	}

	@Override
	public void update(){
		prepareForShooting();
	}
	
	@Override
	protected void shoot() {
		if(!(enemysInRange == null)){
			game.Game.objectsToAdd.add(new EMPBlast(x, y, damage));
		}
	}
}
