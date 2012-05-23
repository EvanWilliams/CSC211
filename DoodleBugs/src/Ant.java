
public class Ant extends Organism {

	private final int BREEDING_FREQ = 3;
	
	
	public Ant(int x, int y,World g) {
		super(x,y,g);
		type = "a";
		
	}
	
private void isEmptyAdjacent(int x, int y) {

		if ((myMap.isCellEmpty(x, y + 1))){
			Ant newAnt = new Ant(x, y+1, myMap);
			myMap.setCell(x, y+1, newAnt);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x, y - 1))){
			Ant newAnt = new Ant(x, y-1, myMap);
			myMap.setCell(x, y-1, newAnt);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x+1, y))){
			Ant newAnt = new Ant(x+1, y, myMap);
			myMap.setCell(x+1, y, newAnt);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		else if ((myMap.isCellEmpty(x-1, y))){
			Ant newAnt = new Ant(x-1, y, myMap);
			myMap.setCell(x-1, y, newAnt);
			timeSinceBreeding=0;
			setMoveFlag();
		}
		return;
		
	}
	/* Ants may breed, but never starve.
	 * @see Organism#doBiology()
	 */
	public void doBiology(int x,int y) {
		timeSinceBreeding++;
		if(timeSinceBreeding>BREEDING_FREQ)
			isEmptyAdjacent(x,y);
			
	}

	/* Ants try to move to an adjacent empty square.  
	 * @see Organism#move()
	 */
//	public void move() {
//	  	moveToEmpty();
//	}
	
	public String toString() {
		String result=" a";
		return result;
	}

}
