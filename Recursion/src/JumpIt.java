import java.util.Random;
import java.util.Scanner;

//Evan Williams
//CSC211 Evett
//2012-6-11

public class JumpIt {
	static int[] Board;
	public static Random generator;
	public static boolean continueLoop;
	public static int BoardSize;
	static int Totalcount = 0;
	static boolean HasGone = false;

	public static void main(String[] args) {
		continueLoop = true;
		Scanner scan = new Scanner(System.in);
		generator = new Random();
		int x = 0;

		System.out.println("How big of a game board would you like?");
//Do Try While to enter the number for how large the board will be and handle exceptions
		do {
			try {
				System.out.println("Enter an Integer 2 or more that is less than 50 ");
				x = scan.nextInt();
				if (x < 3)
					throw new Exception();
				System.out.println(x);
				continueLoop = false;

			} catch (Exception e) {
				System.out.println("Invalid value");
				scan.nextLine();
			}
//Create the game "Board"
		} while (continueLoop == true);
		BoardSize = x;
		System.out.println("I will create a board that is " + x
				+ " squares long");
		Board = new int[x];

		for (int i = 0; i < x; i++) {
			int newLoc = thisRand(100);
			Board[i] = newLoc;
		}
		System.out.println(XString());
		ShortestPossibleRoute(0, 1);
		System.out
				.println("The smallest number to get to the end for this map is : "
						+ Totalcount);

	}
// Method to determine the shortest possible route
	public static int ShortestPossibleRoute(int x, int y) {

		int Buffer = 0;
		int Place = 0;
		int C = 0;
		int i = x;
		int j = y;
		if (HasGone == false) {
			if (j < BoardSize || i < BoardSize) {

				if (Board[i] == Board[BoardSize - 1]
						&& Board[BoardSize - 1] < Board[BoardSize - 2]) {
					Buffer = Board[BoardSize - 1];
					C = Totalcount + Buffer;
					Totalcount = C;
					return Totalcount;
				}
				if (Board[i] < Board[j]) {
					Buffer = Board[i];
					C = Totalcount + Buffer;
					Totalcount = C;
					if (i < BoardSize - 1) {
						Place = i + 1;
					}
					//Recursion
					if (Place + 1 < BoardSize)
						ShortestPossibleRoute(Place, Place + 1);
				}

				else if (Board[i] > Board[j]) {
					Buffer = Board[j];
					C = Totalcount + Buffer;
					Totalcount = C;
					if (j < BoardSize - 1) {
						Place = j + 1;
					} else {
						HasGone = true;
					}
					//Recursion
					if (Place + 1 < BoardSize)
						ShortestPossibleRoute(Place, Place + 1);
				}
			}
			if (HasGone == false) {
				if (Board[BoardSize - 1] > Board[BoardSize - 2]) {
					Buffer = Board[BoardSize - 1];
					C = Totalcount + Buffer;
					Totalcount = C;
					HasGone = true;
					return Totalcount;
				}
			}
		}
		return Totalcount;

	}
//Rando Generator
	public static int thisRand(int x) {

		return generator.nextInt(x);

	}
//ToString
	public static String XString() {

		for (int i = 0; i < BoardSize; i++) {
			System.out.print(Board[i]);
			System.out.print(" ");

		}
		return " ";
	}

}
//OutPut:
//	How big of a game board would you like?
//			Enter an Integer 2 or more
//			6
//			6
//			I will create a board that is 6 squares long
//			36 82 64 6 99 17  
//			The smallest number to get to the end for this map is : 123