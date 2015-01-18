package gameObjects;

public interface shootable {

	public Enemy aim(); 

	public boolean shoot(Enemy enemy);
	
	public void hit();

}
