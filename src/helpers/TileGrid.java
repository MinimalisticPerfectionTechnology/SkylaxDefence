package helpers;

import org.newdawn.slick.opengl.Texture;

import game.Game;
import gameObjects.Map;
import helpers.Draw;

public class TileGrid {
	//public Tile[][] map;



	private int[][] mapArray = Map.map;
	private final int TILE_SIZE = Draw.HEIGHT/mapArray.length+1;


	private Texture grass = null;
	private Texture dirt = null;

	public TileGrid() {

		mapArray = Map.map;
		grass = Draw.createTexture(true);
		dirt = Draw.createTexture(false);

	}

	public void  draw(){
		for(int i = 0; i< mapArray[0].length; i++) {
			for(int j = 0; j < mapArray.length; j++){
				if(mapArray[j][i] == 0) {
					Draw.DrawQuadTex(grass, i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
				} else if(mapArray[j][i] == 1) {
					Draw.DrawQuadTex(dirt,i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}
	}



		/*
	Texture grass = Draw.createTexture(true);

	map = new Tile[Map.map.length][Map.map[0].length];
	for(int i = 0; i < map.length; i++){
		for(int j = 0; j < map[0].length; j++){
			if(Map.map[i][j] == 1) {

//				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
				map[i][j] = Draw.DrawQuadTex(grass, 0, 0, 64, 64;
			}
		}
	}

		 */

		/*public TileGrid2(){
		map = new Tile[10][15];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
			}
		}
	}*/

		//you might want to use this one,
		//it's prbably a good method.
		/*
	public void Draw(){
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				Draw.DrawQuadTex(t.getTexture(), t.getWidth(), t.getHeight(), t.getWidth(), t.getHeight());
			}
		}
	}
		 */
	}
