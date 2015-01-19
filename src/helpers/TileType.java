package helpers;

public enum TileType {
	Grass("Grass64", true), Dirt("Dirt64", false);

	String textureName;
	boolean buildable;

	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}