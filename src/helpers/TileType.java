package helpers;

public enum TileType {
	Grass("Grass64", true), Dirt("Dirt53", false);

	String textureName;
	boolean buildable;

	TyleType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
