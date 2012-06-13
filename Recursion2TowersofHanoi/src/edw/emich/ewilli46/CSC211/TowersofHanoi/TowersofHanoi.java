package edw.emich.ewilli46.CSC211.TowersofHanoi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersofHanoi {
	/**
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
				System.out.println("Where would you like to move?");
				System.out.println("Choose an integer between 1 and 3 for each of the next two choices ");
				System.out.println("1 will be refered as 'A', 2 as 'B', and 3 as 'C' \n");
				System.out.println("enter an Int for the FromPost ");

				int buffer = scan.nextInt();
				
				if (buffer == 1)
					Fresh.setFromPost("A");
				else if (buffer == 2)
					Fresh.setFromPost("B");
				else if (buffer == 3)
					Fresh.setFromPost("C");
				else
					Fresh.setToPost("A");
				
				System.out.println("enter an Int for the ToPost ");
				
				buffer = scan.nextInt();
				if (buffer == 1)
					Fresh.setToPost("A");
				else if (buffer == 2)
					Fresh.setToPost("B");
				else if (buffer == 3)
					Fresh.setToPost("C");
				else
					Fresh.setToPost("B");

				System.out.println("You want to move all of the disks from "
						+ Fresh.getFromPost() + " to " + Fresh.getToPost() + "\n");
				continueLoop = false;
			}

			catch (InputMismatchException e) {
				System.out.println("one of both of your entries is invalid \n");
				scan.nextLine();

			}

		} while (continueLoop == true);
		System.out.println("Drawing the board");
		

	}

	public static char Post(char c) {
		return 'c';
		// boolean has

	}
}
