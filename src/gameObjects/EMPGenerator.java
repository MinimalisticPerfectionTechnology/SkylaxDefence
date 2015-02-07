package gameObjects;

public class EMPGenerator extends Tower{

	public EMPGenerator(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(){
		prepareForShooting();
	}
	
	@Override
	protected void shoot() {
		Shot shot = new EMPBlast(sx, sy, dx, dy);
	}
}
