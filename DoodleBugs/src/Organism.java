import java.util.Random;

abstract public class Organism extends GridPoint {
	//protected int locX, locY; // Coords of organism in its World.
	protected boolean hasMoved; // Movement flag: true if has already moved this
								// turn [Can you see why this is needed?]
	protected int howLongSinceBreeding; // Number of turns since I last bred
	abstract public void doBiology(int x,int y);
	protected World myMap; // Need this so each organism has access to its
							// World.
	protected int timeSinceBreeding;
	private Random generator;

	/**
	 * As this is an abstract class, this constructor is invoked via super() by
	 * its subclasses. Takes care of initializing the fields they inherit from
	 * this class.
	 * 
	 * @param x
	 * @param y
	 * @param m
	 */
	public Organism(int x, int y, World g) {
		// Initialize instance variables, including
		myMap = g;
		generator = new Random();
		timeSinceBreeding = 1;
//		locX = x ;
//		locY = y;
		// YOUR CODE HERE!
	}

	/**
	 * Choose a random direction. If that cell is empty, move there. Make sure
	 * to set the movement flag so there is no possibility of moving the same
	 * organism again this turn.
	 * 
	 * @see clearMoveFlag
	 */
	public int thisRand(int x) {

		return generator.nextInt(x);

	}


	public void move(int locX,int locY) {

		if(hasMoved())
			return;	
			int newLoc = thisRand(4) + 1;
			switch (newLoc)

			{
			// North
			case 1:
				if (locY>Constants.HEIGHT-1)
					return;
				if ((isCellEmpty(locX, locY + 1))) {
					kill(locX,locY);
					myMap.getCells()[locX][locY+1] = this;
					setMoveFlag();
				}
				break;
			// East
			case 2:
				if (locX>Constants.WIDTH-1)
					return;
				if (isCellEmpty(locX + 1, locY)) {
					kill(locX,locY);
					myMap.getCells()[locX+1][locY] = this;
					setMoveFlag();
				}
				break;
			// South
			case 3:
				if (locY <0)
					return;
				if (isCellEmpty(locX, locY - 1)) {
					kill(locX,locY);
					myMap.getCells()[locX][locY-1] =this;
					setMoveFlag();
				}
				break;
			// West
			case 4:
				if (locX<0)
					return;
				if (isCellEmpty(locX - 1, locY)) {
					kill(locX,locY);
					myMap.getCells()[locX-1][locY] =this;
					setMoveFlag();
				}
				break;
			}
		}
	public boolean isCellEmpty(int xcood, int ycood) {
		if ((xcood<0 || xcood>Constants.WIDTH-1)||(ycood<0 || ycood>Constants.HEIGHT-1))
			return false;
		if (myMap.getCells()[xcood][ycood] instanceof Organism) {
			return false;
		}
		return true;
	}

	/**
	 * Clear the move flag.
	 */
	public void clearMoveFlag() {
		hasMoved = false;
	}

	public void setMoveFlag() {
		hasMoved = true;
	}
	
	public boolean hasMoved() {
		return hasMoved;
	}
	/**
	 * Remove the organism from the world. TODO make kill return a gridpoint not
	 * null
	 */
	public void kill(int locX,int locY) {
		GridPoint X = new GridPoint();
		myMap.setCell(locX, locY, X);
	}

	public void moveToEmpty() {

		// Remember to avoid moving a critter that has already moved this
		// turn....

		// YOUR CODE HERE!
	}

}