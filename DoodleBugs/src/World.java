import java.util.Random;

public class World {

	public GridPoint[][] getCells() {
		return cells;
	}

	public void setCells(GridPoint[][] cells) {
		this.cells = cells;
	}

	private GridPoint cells[][]; // (0,0) is considered the upper left corner
	private Random generator; // Use of a Random generator lets us provide same
//	Ant g = new Ant(0,0);	
//	Doodlebug newDoodlebug = new Doodlebug(0,0);
								// sequence of "random" numbers. Consequently,
								// the
								// simulation will be identical each run, aiding
								// debugging.
								// See the World() constructor.

	/**
	 * @param x
	 *            horizontal grid coordinate
	 * @param y
	 *            vertical grid coordinate.
	 * 
	 * @return If (x,y) are not legal coords, returns null. Else returns value
	 *         of the that cell. This will either be an Organism or null.
	 */
	public GridPoint getCell(int x, int y) {
		if (x < 0 || x >= Constants.WIDTH || y < 0 || y >= Constants.HEIGHT)
			return null;
		return cells[x][y];
	}

	/**
	 * @param x
	 *            horizontal grid coordinate
	 * @param y
	 *            vertical grid coordinate.
	 * @param org
	 *            Organism to place in the world
	 */
	public void setCell(int x, int y, GridPoint Grid) {
		cells[x][y] = Grid;
	}
	

	/**
	 * @param x
	 *            horizontal grid coordinate
	 * @param y
	 *            vertical grid coordinate.
	 * @return Return false if cell at given coords is not empty, or if
	 *         coordinates are "off the grid." Else return true.
	 */
//	public boolean isEmptyCell(int x, int y) {
//		if(cells[x][y] != null)
//		{return false;}
//		else return true;
//	}

	/**
	 * @param x
	 * @return Return an integer in the range 0 to (x-1), inclusive.
	 */
	public int myRand(int x) {

		// Return an int in range 0 to (x-1)

		return generator.nextInt(x);

		// (int)(x * Math.random());
	}

	/**
	 * Construct a World. If you don't want repeatable simulations (i.e., you
	 * want each to be unique), remove the "seed" value from the Random()
	 * constructor.
	 * 
	 * @param numAnts
	 *            The number of Ants to place randomly in the grid.
	 * @param numDoodles
	 *            The number of Doodlebuggs to place randomly in the grid.
	 */
	public World(int numAnts, int numDoodles) {
		 int noA = numAnts;
		 int noD = numDoodles;
		// [Exactly one of the next two lines should be commented out...]
		// generator = new Random(1000L); // Each run will be the same. Can use
		// any long as the seed.
		generator = new Random(); // With no seed specified, each run will be
									// different.
		cells = new GridPoint[Constants.WIDTH][Constants.HEIGHT];
		
		for(int j = 0; j<Constants.WIDTH; j++){
			for(int k = 0; k<Constants.HEIGHT; k ++){
			GridPoint newGridpoint = new GridPoint();
			setCell(j, k, newGridpoint);
			}
		}
		
		for (int i = 0; i < noA; i++) {
			int newLoc = myRand(400);
			int XcoodA = (newLoc / Constants.WIDTH);
			int YcoodA = (newLoc % Constants.HEIGHT);
			
			if (isCellEmpty(XcoodA, YcoodA)) {
				Ant newAnt = new Ant (XcoodA,YcoodA,this);
				setCell(XcoodA, YcoodA, newAnt);
			}
			
		}
		
		for(int i = 0; i < noD; i++){
			int newLoc = myRand(400);
			int XcoodA = (newLoc / 20);
			int YcoodA = (newLoc % 20);
			
			if (isCellEmpty(XcoodA, YcoodA)) {
				Doodlebug newDoodlebug = new Doodlebug (XcoodA,YcoodA,this);
				setCell(XcoodA, YcoodA, newDoodlebug);
			}
		}
		// YOUR CODE HERE to randomly place ants and doodlebugs.

	}

		
//	public Ant fillAnts(int x) {
//		for(int i =0; i<x;i++){
//			Ant newAnt = new Ant(Xcood,Ycood);
//			return newAnt;
//		}
//	
//		}
//    public Organism getcells(cells[])
//    {
//    	Ncells][] = cells[]
//		return g;
//   
//    }
	public boolean isCellEmpty(int xcood, int ycood) {
		if(cells[xcood][ycood] instanceof Ant || cells[xcood][ycood] instanceof Doodlebug )
		{return false;}
		return true;
	}

	/*
	 * @return Return printed representation of the World's grid. Print this to
	 * see where all the doodlebugs and ants are currently.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "";
		for (int j = 0; j < Constants.HEIGHT; j++) {
			String strOut = String.format("%2d=", ((j + 1) % 10));
			System.out.print(strOut);

			for (int i = 0; i < Constants.WIDTH; i++)
				System.out.print(cells[i][j]);
			System.out.println();
		}
		// YOUR CODE HERE to build result to be a printed representation of the
		// world.
		// You'll want to make use of singleCharRepresenting() via polymorphism.
		return result;
	}

	/**
	 * @param x
	 * @param y
	 * @param org
	 * @return Return true if a new organism was added to the World, else return
	 *         false. If at least one of the adjacent cells to [x,y] is empty,
	 *         randomly select one of the empty ones and place org there. [You
	 *         might do this by first checking if there's at least one empty
	 *         adjacent cell. If so, use a loop to successively randomly select
	 *         an adjacent cell until you find an empty one, then place org
	 *         there.]
	 * 
	 *         [Oh, and this might be a good place to use a "switch" statement
	 *         to deal with the four possible directions N,S,E,W.]
	 */
	public boolean addAdjacent(int x, int y, Organism org) {
		// YOUR CODE HERE....
		return true; // MODIFY SO RETURNS TRUE ONLY WHEN APPROPRIATE
	}

	/**
	 * Move all the ants.
	 */
	public void moveAllAnts() {
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Ant)
					((Organism)(getCells())[x][y]).move(x, y);
			}
		}
	}

	public void ClearAllMoveF() {
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Organism)
					((Organism)getCell(x, y)).clearMoveFlag() ;
			}
		}
	}
	/**
	 * Move all the doodlebugs.
	 */
	public void moveAllDoodles() {
		System.out.println("World.moveAllDoodles() not yet implemented.\n");
		// YOUR CODE HERE
	}

	/**
	 * Allow each eligible critter to breed, and possibly to starve. Also, clear
	 * the flags indicating that critters have moved. Possible design to
	 * accomplish this: iterate across all cells. If a cell is occupied clear
	 * its movement flag and have it do its biology (if there's breeding, this
	 * may result in new Organisms being created that you'll come across as this
	 * iteration continues).
	 */
	public void doAllBiology() {
		System.out.println("World.doAllBiology() not yet implemented.\n");
		// YOUR CODE HERE. Iterate over the cells, clearing movement flags and
		// breeding,
		// if appropriate.
	}

//	public static void main(String[] args) {
//		World w;
//		w = new World(1, 1);
//		System.out.println("A very thinly populated world:\n" + w);
//		w = new World(0, 0);
//		System.out.println("An empty world:\n" + w);
//		w = new World(10, 10);
//		System.out.println("A thinly populated world:\n" + w);
//		w = new World(30, 10);
//		System.out.println("A populated world:\n" + w);
//		w = new World(10, 10);
//
//	}

}
