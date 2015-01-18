package gameObjects;

public abstract class GameObject {

	protected float r;
	protected float g;
	protected float b;
	protected float x;
	protected float y;
	protected float sx;
	protected float sy;

	public abstract void update();

	public void render() {
		Draw.rect(r, g, b, x, y, sx, sy);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSX() {
		return sx;
	}

	public float getSY() {
		return sy;
	}

	public float getCenterY() {
		return y + sy / 2;
	}

	protected void init(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
