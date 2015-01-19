package helpers;

import static org.lwjgl.opengl.GL11.*;
//import game.Main;

import java.io.IOException;
import java.io.InputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.opengl.Display;

public class Draw {
//	public static final int WIDTH = 960, HEIGHT = 540;
	public static final int WIDTH = 1500, HEIGHT = 800;
//	 public static final int WIDTH = 1920, HEIGHT = 1080;

	public static void initDisplay() {
		Display.setTitle("Scylax Defence");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
//			Display.setVSyncEnabled(true);
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			// Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,
			// e);
		}
	}

	public static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		// glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glOrtho(0, WIDTH, 0, HEIGHT, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0, 0, 0, 1);
		// glDisable(GL_DEPTH_TEST);
	}

	public static void background() {
		Texture t = LoadTexture("res/dark_background.jpg", "JPG");
//		glPushMatrix();
		DrawQuadTex(t, 0, 0, WIDTH, HEIGHT);
	}
	
	public static void grass(){
		Texture t = LoadTexture("res/Rp9oxyl.png", "PNG");
		DrawQuadTex(t, 0, 0, 64, 64);
	}

	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
//		glPushMatrix();
		glEnable(GL_TEXTURE_2D);
		tex.bind();
		glTranslatef(x, y, 0);
//		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(1, 0);
			glVertex2f(width, 0);
			glTexCoord2f(1, 1);
			glVertex2f(width, height);
			glTexCoord2f(0, 1);
			glVertex2f(0, height);
		}
		glEnd();
//		glLoadIdentity();
	}

	public static void rect(float r, float g, float b, float x, float y,
			float width, float height) {
		rect(r, g, b, x, y, width, height, 0);
	}

	public static void rect(float r, float g, float b, float x, float y,
			float width, float height, float rotation) {
		glDisable(GL_TEXTURE_2D);
		glPushMatrix();
		{
			width /= 2;
			height /= 2;
			glTranslatef(x, y, 0);
			glRotatef(rotation, 0, 0, 1);
			glColor3f(r, g, b);
			glBegin(GL_QUADS);
			{
				glVertex2f(-width, -height);
				glVertex2f(-width, height);
				glVertex2f(width, height);
				glVertex2f(width, -height);
			}
			glEnd();
		}
		glPopMatrix();
	}

	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}
}
