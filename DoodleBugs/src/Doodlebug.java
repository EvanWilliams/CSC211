
public class Doodlebug extends Organism {

	private final int BREEDING_FREQ= 7;  // Doodlebugs can breed if they have lived at 
	// least this many turns since last breeding.
	private final int EATING_LIMIT = 3; // Doodles gotta eat every this many turns
	private int turnsSinceEating;		// Number of turns since the doodlebug last ate.
	int numTrys = 0;
	public Doodlebug(int x, int y,World g) {
		super(x,y,g);
		type = 'D';
	}

	/* Check to see if the doodlebug should starve.  If not, check to see if the doodlebug
	 * might procreate.
	 * @see Organism#doBiology()
	 */
	public void doBiology() {
		// YOUR CODE HERE!
	}

	/* If there is an adjacent ant, move to it, consuming it.  Else, possibly move to 
	 * an empty adjacent cell.
	 * @see Organism#move()
	 */

//	public void secondChance(int x, int y){
//		while(numTrys<2){
//			move(x,y);
//		}
//	}
	public void move(int x, int y) {

		if(hasMoved())
			return;
		while(numTrys!=2){
		int newLoc = thisRand(4) + 1;
		switch (newLoc)

		{
		// North
		case 1:
			if (y+1>Constants.HEIGHT-1)
				return;
			if(isCellAnt(x, y + 1)) {
				kill(x,y);
				myMap.getCells()[x][y+1] = this;
				setMoveFlag();
			}
			if(isCellEmpty(x, y + 1)){
				numTrys++;

				if (numTrys!=1)
					kill(x,y);
				myMap.getCells()[x][y+1] = this;
				setMoveFlag();
			}
			break;
			// East
		case 2:
			if (x+1>Constants.WIDTH-1)
				return;
			if ((isCellEmpty(x+1, y))||(isCellAnt(x+1, y))) {
				kill(x,y);
				myMap.getCells()[x+1][y] = this;
				setMoveFlag();
			}
			if(isCellEmpty(x, y + 1)){
				numTrys++;

				if (numTrys!=1)
					kill(x,y);
				myMap.getCells()[x][y+1] = this;
				setMoveFlag();
			}
			break;
			// South
		case 3:
			if (y-1 <0)
				return;
			if ((isCellEmpty(x, y - 1))||(isCellAnt(x, y - 1))) {
				kill(x,y);
				myMap.getCells()[x][y-1] =this;
				setMoveFlag();
			}
			if(isCellEmpty(x, y + 1)){
				numTrys++;

				if (numTrys!=1)
					kill(x,y);
				myMap.getCells()[x][y+1] = this;
				setMoveFlag();
			}
			break;
			// West
		case 4:
			if (x-1 <0)
				return;
			if ((isCellEmpty(x-1, y))||(isCellAnt(x-1, y))) {
				kill(x,y);
				myMap.getCells()[x-1][y] =this;
				setMoveFlag();
			}
			if(isCellEmpty(x, y + 1)){
				numTrys++;

				if (numTrys!=1)
					kill(x,y);
				myMap.getCells()[x][y+1] = this;
				setMoveFlag();
			}
			break;
		}
		}
	}



/**
 * @return True, if there is at least one adjacent cell containing an ant.  In that case
 * the doodlebug will move there, consuming the ant.  Else, return false.
 *
 * Note that this a private method, which means it is a "helper" method.  My implementation
 * of doBiology calls it.  You don't need a method like this, necessarily.  There are many 
 * ways of solving the problem.
 * 
 */
private boolean moveToEatIfPossible() {
	// generate random number (2)
	// YOUR CODE HERE!
	return true; // MODIFY SO DOESN'T ALWAYS RETURN TRUE
}

/**
 * @param x  coordinates of spot to examine
 * @param y
 * @return  If there is an ant at the specified grid location, move there, consuming it.
 * Note that there is an implicit ordering: the Doodlebug will first look to N, then S, then W, then E.
 * Will only move onto one of those spaces.  You might choose to implement this so that the order in which
 * the doodlebug looks in the various directions is random.  It's up to you!
 * 
 *  Again, this is a private (i.e., "helper") method.  You don't need it, necessarily.  Don't freak
 * out if you can't see how you might want to use a method like this.   My own implementation of
 * move() used it, but yours might not!
 */
private boolean moveToAntIfAdjacent(int x, int y) {
	// YOUR CODE HERE (if you decide to implement this method)!
	return true; // MODIFY SO DOESN'T ALWAYS RETURN TRUE
}

/**
 * You might use this when generating debugging output.
 * [If you want to do what I did and have each doodlebug represented by a
 * digit equal to the number of turns since it had last eaten, you'll want
 * to modify either this method or (more likely) singleCharRepresenting.]
 */
//	public String toString() {
//		return "D"; 
//		}

public String singleCharRepresenting() {
	return "D";
}

}
