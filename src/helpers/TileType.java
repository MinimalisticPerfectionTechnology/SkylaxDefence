package helpers;

public enum TileType {
	Grass("Grass", true), Dirt("Dirt", false);

	String textureName;
	boolean buildable;

	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}