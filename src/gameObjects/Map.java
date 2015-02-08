package gameObjects;

import helpers.Draw;

public class Map {
	
	/*
	 * OOOOOOBBBBBBBSSSSSSS this list is reversed Y-wise!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	private int[][] map = new int[][]{
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		

	};
	private int[] nrOfEntities;
	
	
	/*
	 * nrOfEntities simply consists of
	 * the number of elements map[][] contains
	 * by, side-wise and height-wise.
	 */
	public Map() {
		nrOfEntities = new int[]{map[0].length, map.length};
	}

	/*
	 * converts an objects x to the map.
	 */
	private int normalizedX(float X) {
		return (int) (X/Draw.WIDTH*nrOfEntities[0]);
	}
	private int normalizedY(float Y) {
		return (int) (Y/Draw.HEIGHT*nrOfEntities[1]);
	}
	
	/*
	 * this method takes a gameobjects x and y and an integer
	 * representing where it came from.
	 * it then calls the its private function that returns
	 * where the next level-piece is located. 1 for right
	 * 2 for down, 3 for left and 4 for up. if there is no
	 * level-piece around the object it returns 0.
	 * but if the call returns a number that is the same
	 * the enemy came from, then it calls the funciton
	 * again but lets it start from the "direction" that
	 * it got stuck. and return that instead. continue reading
	 * and it will get clearer.
	 */

	public int getDirection(float floatX, float floatY, int cameFrom) {
		int x = normalizedX(floatX);
		int y = normalizedY(floatY);
		int pathSpot = getDirection(0, x, y);
		if(pathSpot != cameFrom) {
			return pathSpot;
		}
		return getDirection(pathSpot+1, x, y);
	}

	
	/*gets an x and y and also an order that indicates
	 * where to start. it's likely to call itself recurively
	 * and in that case it will sen a new order number representing
	 * right, down, left or up and if it finds a piece that is 1 there then it
	 * returns that. as mentioned it will return 0 if no brick was found around it.
	 */
	
	

	private int getDirection2(int order, int X, int Y) {
		if(X >= 0 && X<nrOfEntities[0] && Y >= 0 && Y<nrOfEntities[1]) {
			if(map[Y][X] == 1) {
				return order;
			} else if (map[Y][X] == 1){
				
			}
			else if(order > 4) return 0;
			else {
				switch(order) {
				case 0: return getDirection(order+1, X+1, Y);
				case 1: return getDirection(order+1, X-1, Y+1);
				case 2: return getDirection(order+1, X-1, Y-1);
				case 3: return getDirection(order+1, X+1, Y+1);
				}
			}
		}
		return 0;
	}

	
	
	private int getDirection(int order, int X, int Y) {
		if(X >= 0 && X<nrOfEntities[0] && Y >= 0 && Y<nrOfEntities[1]) {
			if(map[Y][X] == 1 && order != 0) {
				return order;
			}
			else if(order > 4) return 0;
			else {
				switch(order) {
				case 0: return getDirection(order+1, X+1, Y);
				case 1: return getDirection(order+1, X-1, Y+1);
				case 2: return getDirection(order+1, X-1, Y-1);
				case 3: return getDirection(order+1, X+1, Y+1);
				}
			}
		}

		

		return 0;
	}


	public float snapToY(float y) {
		float leftOver = Draw.HEIGHT%nrOfEntities[1];
		float mod = y%leftOver;
		return y + mod;
	}
	public float snapToX(float x) {
		float leftOver = Draw.WIDTH%nrOfEntities[0];
		float mod = x%leftOver;
		return x + mod;
	}

}
