
public class Ant extends Organism {

	private final int BREEDING_FREQ = 3;

	public Ant(int x, int y,World g) {
		super(x,y,g);
		type = 'a';
		
	}
	
	/* Ants may breed, but never starve.
	 * @see Organism#doBiology()
	 */
	public void doBiology() {
	  	// YOUR CODE HERE....
	}

	/* Ants try to move to an adjacent empty square.  
	 * @see Organism#move()
	 */
	public void move() {
	  	moveToEmpty();
	}
	
//	public String toString() {
//		String result="a";
//		return result;
//	}
	
	public String singleCharRepresenting() {
		return "a";
	}


}
