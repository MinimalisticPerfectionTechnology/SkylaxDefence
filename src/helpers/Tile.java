package helpers;
import org.newdawn.slick.opengl.Texture;
public class Tile {
	private float x, y, width, height;
	private Texture texture;
	private TileType tileType;
		
	}

	public Tile(float x, float y, float width, float height, TileType type) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tileType = type;
		this.texture = quickLoad(type.textureName);
	}
}
