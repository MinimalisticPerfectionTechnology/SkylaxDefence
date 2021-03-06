package gameObjects;

import helpers.Draw;
import gameObjects.*;

public class GameObject {

	protected float red;
	protected float green;
	protected float blue;
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected float radius;
	protected float dx;
	protected float dy;

	public void update() {
	}

	public void render() {
//		Draw.rect(red, green, blue, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getCenterY() {
		return y + width / 2;
	}

	protected void init(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
