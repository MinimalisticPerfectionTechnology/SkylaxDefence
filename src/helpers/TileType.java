package helpers;

public enum TileType {
	Grass(true), 
	Dirt(false);

	String textureName;
	boolean buildable;

	TileType(boolean buildable){
		this.buildable = buildable;
	}
}