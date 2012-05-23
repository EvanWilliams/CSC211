import java.util.Scanner;

/**
 * @author Evan Williams E00887504 Csc211 DoodleBugs Lab This is a simple
 *         Predator-prey Simulation with Ants(Prey) and DoodleBugs(Predator)
 *         existing on an Array of GridPoints. Both the Ants and DoodleBugs
 *         reproduce after a number of turns Only the Doodlebugs may eat the
 *         Ants. Simulation Continues until one species is extinct
 * 
 */
public class Doodle {

	private static final int NUM_ANTS = 25;
	private static final int NUM_DOODLES = 10;

	public static void main(String[] args) {
		int turns = 0;
		Scanner scan = new Scanner(System.in);
		World theMap = new World(NUM_ANTS, NUM_DOODLES);

		System.out.println(theMap);
		System.out.println("Number of Ants :" + NUM_ANTS);
		System.out.println("Number of Doodles :" + NUM_DOODLES);
		System.out.print("Hit return to continue, q to stop: ");
		System.out.println();
		System.out.println("----------------------------------------");

		while (!scan.nextLine().equals("q")) {
			turns++;
			theMap.moveAllAnts();
			theMap.moveAllDoodles();
			theMap.doAllBiology();
			theMap.countAllOrganisms();
			theMap.ClearAllMoveF();

			System.out.println();
			System.out.println("Number of Ants :" + theMap.getNumAnts());
			if (theMap.getNumAnts() == 0) {
				System.out
						.println("There are no Ants. The Doodles are Victorious!");
				System.exit(0);
			}

			System.out.println("Number of Doodles :" + theMap.getNumDoodles());
			if (theMap.getNumDoodles() == 0) {
				System.out
						.println("There are no Doodles. The Ants are Victorious!");
				System.exit(0);
			}
			System.out.println();
			System.out.print(theMap + "\nTurn " + turns
					+ ".  Hit return to continue, q to stop: ");
			System.out.println();
			System.out.println("----------------------------------------");
		}

	}

}
