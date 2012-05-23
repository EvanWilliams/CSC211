import java.util.Scanner;


public class Doodle {

	private static final int NUM_ANTS = 12; //Increase to a bigger number when testing biology
	private static final int NUM_DOODLES = 7;
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		int turns = 0;
		Scanner scan = new Scanner(System.in);
		World theMap = new World(NUM_ANTS, NUM_DOODLES);
		
		//theMap.fillAnts();
		

		System.out.println(theMap);
		System.out.println("Number of ants: " +NUM_ANTS);
		System.out.println("Number of Doodles "+NUM_DOODLES);
		System.out.print("Hit return to continue, q to stop: ");
		
		while (!scan.nextLine().equals("q")){
			turns++;
			theMap.moveAllAnts();
//			System.out.println("After moving ants...\n"+theMap);
			// Decomment the next line when you are ready to test the movement of doodlebugs    
			theMap.moveAllDoodles();
//			System.out.println("After moving the doodles...\n"+theMap);
			theMap.countAllOrganisms();
			// Decomment the next line when you are ready to start testing biology
			 theMap.doAllBiology();  // Also clears Move flags
			// Debugging... System.out.println("After biology...\n"+theMap);
			theMap.ClearAllMoveF();
			System.out.print(theMap +"\nTurn "+turns+".  Hit return to continue, q to stop: ");
			System.out.println();
			System.out.println("----------------------------------------");
		}
		
	}

}
