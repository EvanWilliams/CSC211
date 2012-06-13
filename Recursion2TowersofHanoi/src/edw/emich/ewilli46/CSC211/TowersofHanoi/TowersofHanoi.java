package edw.emich.ewilli46.CSC211.TowersofHanoi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersofHanoi {
	/**
	 * Evan Williams
	 * RecursionPart2-Towers of Hanoi
	 * CSC211 Summer 2012
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		boolean continueLoop = true;
		Scanner scan = new Scanner(System.in);
		Hanoi Fresh = new Hanoi();

		System.out.println("Hello and welcome to the Towers of Hanoi Program.");
		do {
			try {
				System.out.println("This Program moves Disks from one post to another.");
				System.out.println("There are 4 Disks and 3 posts.");
				System.out.println("Only smaller plates may sit on larger ones.");

				

				System.out.println("Moveing all of the disks from "
						+ "A to B \n");
				continueLoop = false;
			}

			catch (InputMismatchException e) {
				System.out.println("one of both of your entries is invalid \n");
				scan.nextLine();

			}

		} while (continueLoop == true);
		System.out.println("Drawing the board");
		Fresh.MoveTower();

	}

	public static char Post(char c) {
		return 'c';

	}
}
//
//OutPut:
//	Hello and welcome to the Towers of Hanoi Program.
//	This Program moves Disks from one post to another.
//	There are 4 Disks and 3 posts.
//	Only smaller plates may sit on larger ones.
//	Moveing all of the disks from A to B 
//
//	Drawing the board
//	Move 1 From A To C
//	Move 2 From A To B
//	Move 1 From C To B
//	Move 3 From A To C
//	Move 1 From B To A
//	Move 2 From B To C
//	Move 1 From A To C
//	Move 4 From A To B
//	Move 1 From C To B
//	Move 2 From C To A
//	Move 1 From B To A
//	Move 3 From C To B
//	Move 1 From A To C
//	Move 2 From A To B
//	Move 1 From C To B