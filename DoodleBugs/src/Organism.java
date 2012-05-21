import java.util.Random;

    abstract public class Organism {
	protected int locX,	locY;			// Coords of organism in its World.
	protected boolean hasMoved;  		// Movement flag: true if has already moved this turn [Can you see why this is needed?]
	protected int howLongSinceBreeding;	// Number of turns since I last bred
	abstract public void doBiology();	// Breeding and dying
	protected World myMap;				// Need this so each organism has access to its World.
	private Random generator;
	/**
	 * As this is an abstract class, this constructor is invoked via super() by its
	 * subclasses.  Takes care of initializing the fields they inherit from this class.
	 * @param x
	 * @param y
	 * @param m
	 */
	public Organism(int x, int y) {
	// Initialize instance variables, including
		locX = x;
		locY = y;
		// YOUR CODE HERE!
	}
	/**
	 * Choose a random direction.  If that cell is empty, move there.
	 * Make sure to set the movement flag so there is no possibility of moving the
	 * same organism again this turn.  
	 * @see clearMoveFlag
	 */
	public int thisRand(int x) {

			return generator.nextInt(x);
			
		}
		
//	public boolean isCellEmpty(int xcood, int ycood) {
//		if(cells[xcood][ycood] instanceof Ant || cells[xcood][ycood] instanceof Doodlebug )
//		{return false;}
//		return true;
	
	 private void move(Organism org) {
	
	{
		int newLoc = thisRand(4)+1;
		switch(newLoc)
		
		{
			//North
		case 1:
			if (isCellEmpty(locX, locY+1)) {
			locY = locY+1;
			}
			break;
			//East
		case 2:
			if(isCellEmpty(locX+1, locY)) {
			locX = locX+1;}
			break;
			//South
		case 3:
			if(isCellEmpty(locX, locY-1)) {
			locY = locY-1;}
			break;
			//West
		case 4:
			if(isCellEmpty(locX-1, locY)) {
			locX = locX-1;}
			break;
			}
		}
		
    }
	
	 public boolean isCellEmpty(int xcood, int ycood) {
			if(! cells[xcood][ycood] instanceof GridPoint )
			{return false;}
			return true;
		}
	}
	/**
	 * Clear the move flag.
	 */
	public void clearMoveFlag() {
		hasMoved = false;
	}
	
	/**
	 * Remove the organism from the world.
	 * TODO make kill return a gridpoint not null
	 */
	public void kill() {
		GridPoint X = new GridPoint(locX,locY);
		myMap.setCell(locX, locY, X);
	}
	
	public void moveToEmpty() {
		
		// Remember to avoid moving a critter that has already moved this turn....
	
		// YOUR CODE HERE!
	}
	/**
	 * Set the location of the organism to the given coordinates.
	 * @param x
	 * @param y
	 */
	public void setLoc(int x, int y){
		locX = x;
		locY = y;
	}
	
	/**
	 * @return Return a single character representing the organism.  To be 
	 * used in constructing the printed representation of a World.
	 */
	public String toString() {
		String result="X";
		return result;
	}
}
