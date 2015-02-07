package gameObjects;

public interface shootable {

	public Enemy selectEnemy(); 

	public void shoot(Enemy enemy);
	
	public void hit();

}
