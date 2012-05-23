public class Doodlebug extends Organism {

	private final int BREEDING_FREQ = 7; // Doodlebugs can breed if they have
	// lived at
	// least this many turns since last breeding.
	private final int DEATHLIMIT = 3;// Doodlebugs have to eat every this many
										// turns
	private int DeathTimer; // Number of turns since the Doodlebugs last ate.
	int numTrys = 0;

	public Doodlebug(int x, int y, World g) {
		super(x, y, g);
		DeathTimer = DEATHLIMIT;
		type = "D";

	}

	/**
	 * This is the Breeding method for Doodlebugs Because it seemed unduly
	 * complicated to make the spawning location random The breeding method
	 * tries North first then South then East, and finally West
	 * 
	 * @param x
	 *            = X Location of Organism
	 * @param y
	 *            = Y Location of Organism
	 */
	private void isEmptyAdjacent(int x, int y) {

		if ((myMap.isCellEmpty(x, y + 1))) {
			Doodlebug newDoodlebug = new Doodlebug(x, y + 1, myMap);
			myMap.setCell(x, y + 1, newDoodlebug);
			timeSinceBreeding = 0;
			setMoveFlag();
		} else if ((myMap.isCellEmpty(x, y - 1))) {
			Doodlebug newDoodlebug = new Doodlebug(x, y - 1, myMap);
			myMap.setCell(x, y - 1, newDoodlebug);
			timeSinceBreeding = 0;
			setMoveFlag();
		} else if ((myMap.isCellEmpty(x + 1, y))) {
			Doodlebug newDoodlebug = new Doodlebug(x + 1, y, myMap);
			myMap.setCell(x + 1, y, newDoodlebug);
			timeSinceBreeding = 0;
			setMoveFlag();
		} else if ((myMap.isCellEmpty(x - 1, y))) {
			Doodlebug newDoodlebug = new Doodlebug(x - 1, y, myMap);
			myMap.setCell(x - 1, y, newDoodlebug);
			timeSinceBreeding = 0;
			setMoveFlag();
		}

	}

	/**
	 * @param x
	 *            = X coordinates of Organism
	 * @param y
	 *            = Y coordinates of Organism This method first increments the
	 *            timeSinceBreeding counter Then if the DeathTimer is at zero it
	 *            kills the DoodleBug Finally if the timeSinceBreeding >
	 *            BREEDING_FREQ, the DoodleBug reproduces
	 */
	public void doBiology(int x, int y) {
		timeSinceBreeding++;
		if (DeathTimer<1)
			kill(x, y);
		if (timeSinceBreeding > BREEDING_FREQ)
			isEmptyAdjacent(x, y);
	}

	/**
	 * @param x
	 *            = X coordinates of Organism
	 * @param y
	 *            = Y coordinates of Organism this method first checks around
	 *            the Doodlebug to see if an ant is adjacent, and if it is moves
	 *            to that space and replaces the ant and resets DeathTimer.
	 *            Also,inherits the move method for Organism and increments the
	 *            DeathTimer if the Doodle bug did not eat an ant.
	 */
	public void move(int x, int y) {

		if (hasMoved())
			return;
		if (isAntAdjacent(x, y))
			return;
		else {
			super.move(x, y);
			DeathTimer--;
		}
	}

	/**
	 * @return True, if there is at least one adjacent cell containing an ant.
	 *         In that case the doodlebug will move there, consuming the ant.
	 *         Else, return false.
	 * 
	 */
	/**
	 * @param x
	 *            coordinates of spot to examine
	 * @param y
	 * @return If there is an ant at the specified grid location, move there,
	 *         consuming it. Note that there is an implicit ordering: the
	 *         Doodlebug will first look to N, then S, then E, then W. Will only
	 *         move onto one of those spaces. You might choose to implement this
	 *         so that the order in which the Doodlebug looks in the various
	 *         directions is random. It's up to you!
	 * 
	 */
	private boolean isAntAdjacent(int x, int y) {
		if ((myMap.isCellAnt(x, y + 1))) {
			kill(x, y);
			myMap.getCells()[x][y + 1] = this;
			setMoveFlag();
			DeathTimer = DEATHLIMIT;
		}
		if ((myMap.isCellAnt(x, y - 1))) {
			kill(x, y);
			myMap.getCells()[x][y - 1] = this;
			setMoveFlag();
			DeathTimer = DEATHLIMIT;
		}
		if ((myMap.isCellAnt(x + 1, y))) {
			kill(x, y);
			myMap.getCells()[x + 1][y] = this;
			setMoveFlag();
			DeathTimer = DEATHLIMIT;
		}
		if ((myMap.isCellAnt(x - 1, y))) {
			kill(x, y);
			myMap.getCells()[x - 1][y] = this;
			setMoveFlag();
			DeathTimer = DEATHLIMIT;
		}

		return hasMoved();
	}

	public String toString() {
		if (DeathTimer == 3)
			return " " + type;
		else
			return " " + DeathTimer;
	}

	public String singleCharRepresenting() {
		return "D";
	}

}
