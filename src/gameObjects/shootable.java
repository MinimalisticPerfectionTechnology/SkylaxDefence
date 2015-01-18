package gameObjects;

public interface shootable {

	public GOEnemy aim(); 

	public boolean shoot(GOEnemy enemy);
	
	public void hit();

}
