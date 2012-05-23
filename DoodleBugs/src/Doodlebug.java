
public class Doodlebug extends Organism {

	private final int BREEDING_FREQ= 7;  // Doodlebugs can breed if they have lived at 
	// least this many turns since last breeding.
	private final int DEATHLIMIT=3;
	private int DeathTimer; // Doodles gotta eat every this many turns
		// Number of turns since the doodlebug last ate.
	int numTrys = 0;

	
	public Doodlebug(int x, int y,World g) {
		super(x,y,g);
		DeathTimer = DEATHLIMIT;
		type = "D";
		
	}

	/* Check to see if the doodlebug should starve.  If not, check to see if the doodlebug
	 * might procreate.
	 * @see Organism#doBiology()
	 */
private void isEmptyAdjacent(int x, int y) {
		
		if ((myMap.isCellEmpty(x, y + 1))){
			Doodlebug newDoodlebug = new Doodlebug(x, y+1, myMap);
			myMap.setCell(x, y+1, newDoodlebug);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x, y - 1))){
			Doodlebug newDoodlebug = new Doodlebug(x, y-1, myMap);
			myMap.setCell(x, y-1, newDoodlebug);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x+1, y))){
			Doodlebug newDoodlebug = new Doodlebug(x+1, y, myMap);
			myMap.setCell(x+1, y, newDoodlebug);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x-1, y))){
			Doodlebug newDoodlebug = new Doodlebug(x-1, y, myMap);
			myMap.setCell(x-1, y, newDoodlebug);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		
	}
	public void doBiology(int x,int y) {
		timeSinceBreeding++;
		if(DeathTimer==0)
			kill(x,y);
		if(timeSinceBreeding>BREEDING_FREQ)
			isEmptyAdjacent(x,y);
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
		if(isAntAdjacent(x,y))
			return;
		else{ 
		super.move(x,y);
		DeathTimer--;
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
private boolean isAntAdjacent(int x, int y) {
	if ((myMap.isCellAnt(x, y + 1))){
		kill(x,y);
		myMap.getCells()[x][y+1] = this;
		setMoveFlag();
		DeathTimer=DEATHLIMIT;
	}
	if ((myMap.isCellAnt(x, y - 1))){
		kill(x,y);
		myMap.getCells()[x][y-1] = this;
		setMoveFlag();
		DeathTimer=DEATHLIMIT;
	}
	if ((myMap.isCellAnt(x+1, y))){
		kill(x,y);
		myMap.getCells()[x+1][y] = this;
		setMoveFlag();
		DeathTimer=DEATHLIMIT;
	}
	if ((myMap.isCellAnt(x-1, y))){
		kill(x,y);
		myMap.getCells()[x-1][y] = this;
		setMoveFlag();
		DeathTimer=DEATHLIMIT;
	}
		
	return hasMoved(); // MODIFY SO DOESN'T ALWAYS RETURN TRUE
}

/**
 * You might use this when generating debugging output.
 * [If you want to do what I did and have each doodlebug represented by a
 * digit equal to the number of turns since it had last eaten, you'll want
 * to modify either this method or (more likely) singleCharRepresenting.]
 */
public String toString() {
	if(DeathTimer==3)
		return " "+type;
	else 
		return " "+DeathTimer;
	}

public String singleCharRepresenting() {
	return "D";
}

}
