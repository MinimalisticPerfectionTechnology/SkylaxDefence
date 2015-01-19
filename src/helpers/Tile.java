package helpers;
import org.newdawn.slick.opengl.Texture;
public class Tile {
	private float x, y, width, height;
	private Texture texture;
	private TileType tileType;

	public Tile(float x, float y, float width, float height, TileType type) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tileType = type;
//		this.texture = quickLoad(type.textureName);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TileType getTileType() {
		return tileType;
	}

	public void setTileType(TileType tileType) {
		this.tileType = tileType;
	}
}
