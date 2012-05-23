import java.util.Random;

public class World {
	private int NumAnts = 0;

	private int NumDoodles = 0;

	public GridPoint[][] getCells() {
		return cells;
	}

	public void setCells(GridPoint[][] cells) {
		this.cells = cells;
	}

	public int getNumAnts() {
		return NumAnts;
	}

	public int getNumDoodles() {
		return NumDoodles;
	}

	private GridPoint cells[][]; // (0,0) is considered the upper left corner
	private Random generator; // Use of a Random generator lets us provide same

	public GridPoint getCell(int x, int y) {
		if (x < 0 || x >= Constants.WIDTH || y < 0 || y >= Constants.HEIGHT)
			return null;
		return cells[x][y];
	}

	public void setCell(int x, int y, GridPoint Grid) {
		cells[x][y] = Grid;
	}

	public int myRand(int x) {

		return generator.nextInt(x);

	}

	/**
	 * @param numAnts
	 *            = Number of Ants to be Generated randomly and placed in the
	 *            World
	 * @param numDoodles
	 *            = Number of Doodles to be Generated randomly and placed in the
	 *            World This Method uses a random generator from 0-399 and
	 *            determines a point on the World Array based on the number
	 *            produced and creates Ants or Doodles in that point
	 */
	public World(int numAnts, int numDoodles) {
		int noA = numAnts;
		int noD = numDoodles;
		generator = new Random();
		cells = new GridPoint[Constants.WIDTH][Constants.HEIGHT];

		for (int j = 0; j < Constants.WIDTH; j++) {
			for (int k = 0; k < Constants.HEIGHT; k++) {
				GridPoint newGridpoint = new GridPoint();
				setCell(j, k, newGridpoint);
			}
		}

		for (int i = 0; i < noA; i++) {
			int newLoc = myRand(400);
			int XcoodA = (newLoc / Constants.WIDTH);
			int YcoodA = (newLoc % Constants.HEIGHT);

			if (isCellEmpty(XcoodA, YcoodA)) {
				Ant newAnt = new Ant(XcoodA, YcoodA, this);
				setCell(XcoodA, YcoodA, newAnt);
			}

		}

		for (int i = 0; i < noD; i++) {
			int newLoc = myRand(400);
			int XcoodA = (newLoc / 20);
			int YcoodA = (newLoc % 20);

			if (isCellEmpty(XcoodA, YcoodA)) {
				Doodlebug newDoodlebug = new Doodlebug(XcoodA, YcoodA, this);
				setCell(XcoodA, YcoodA, newDoodlebug);
			}
		}

	}

	/**
	 * @param x
	 *            = X Location of Organism
	 * @param y
	 *            = Y Location of Organism
	 * @returns true if cell is a Gridpoint or else returns false
	 */
	public boolean isCellEmpty(int xcood, int ycood) {
		if (xcood > Constants.WIDTH - 1 || xcood < 0)
			return false;
		if (ycood > Constants.HEIGHT - 1 || ycood < 0)
			return false;
		if (cells[xcood][ycood] instanceof Ant
				|| cells[xcood][ycood] instanceof Doodlebug) {
			return false;
		}
		return true;
	}

	/**
	 * @param x
	 *            = X Location of Organism
	 * @param y
	 *            = Y Location of Organism
	 * @returns true if cells is an instance of Doodlebug or else returns false
	 */
	public boolean isCellDoodlebug(int xcood, int ycood) {
		if ((xcood < 0 || xcood > Constants.WIDTH - 1)
				|| (ycood < 0 || ycood > Constants.HEIGHT - 1))
			return false;
		if (cells[xcood][ycood] instanceof Doodlebug) {
			return true;
		}
		return false;
	}

	/**
	 * @param x
	 *            = X Location of Organism
	 * @param y
	 *            = Y Location of Organism
	 * @returns true if cell is an instance of ant or else returns false
	 */
	public boolean isCellAnt(int xcood, int ycood) {
		if ((xcood < 0 || xcood > Constants.WIDTH - 1)
				|| (ycood < 0 || ycood > Constants.HEIGHT - 1))
			return false;
		if (cells[xcood][ycood] instanceof Ant) {
			return true;
		}
		return false;
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
			String strOut = String.format("%2d=", ((j) % 10));
			System.out.print(strOut);

			for (int i = 0; i < Constants.WIDTH; i++)
				System.out.print(cells[i][j]);
			System.out.println();
		}

		return result;
	}

	/**
	 * Move all the ants.
	 * 
	 * @return
	 */
	public void moveAllAnts() {
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Ant) {
					((Organism) (getCells())[x][y]).move(x, y);
				}

			}
		}
	}

	/**
	 * Scans thru the Array and counts all Organisms
	 */
	public void countAllOrganisms() {
		NumDoodles = 0;
		NumAnts = 0;

		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Doodlebug)
					NumDoodles++;
				else if (getCell(x, y) instanceof Ant)
					NumAnts++;
				// secondChance(x,y);
			}
		}
	}

	/**
	 * Clear all Move Flags
	 */
	public void ClearAllMoveF() {
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Organism)
					((Organism) getCell(x, y)).clearMoveFlag();
			}
		}

	}

	/**
	 * Move all the doodlebugs.
	 */
	public void moveAllDoodles() {
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Doodlebug) {
					((Organism) (getCells())[x][y]).move(x, y);
					NumDoodles++;
				}

			}
		}
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
		for (int y = 0; y < Constants.HEIGHT; y++) {
			for (int x = 0; x < Constants.WIDTH; x++) {
				if (getCell(x, y) instanceof Organism)
					((Organism) getCell(x, y)).doBiology(x, y);
			}

			// public static void main(String[] args) {
			// World w;
			// w = new World(1, 1);
			// System.out.println("A very thinly populated world:\n" + w);
			// w = new World(0, 0);
			// System.out.println("An empty world:\n" + w);
			// w = new World(10, 10);
			// System.out.println("A thinly populated world:\n" + w);
			// w = new World(30, 10);
			// System.out.println("A populated world:\n" + w);
			// w = new World(10, 10);
			//
			// }

		}
	}
}
