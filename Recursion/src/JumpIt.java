import java.util.Random;
import java.util.Scanner;

public class JumpIt {
	static int[] Board;
	public static Random generator;
	public static boolean continueLoop;
	public static int BoardSize;

	public static void main(String[] args) {
		continueLoop = true;
		Scanner scan = new Scanner(System.in);
		generator = new Random();
		int x = 0;

		System.out.println("How big of a game board would you like?");

		do {
			try {
				System.out.println("Enter an Integer ");
				x = scan.nextInt();
				System.out.println(x);
				continueLoop = false;

			} catch (Exception e) {
				System.out.println("Invalid value");
				scan.nextLine();
			}

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
	}

	public int ShortestPossibleRoute(){
		int Totalcount = 0 ;
		int Buffer = 0;
		int Place = 0;
		for(int i = 0; i < BoardSize;i++){
			if(Board[i]<Board[i+1])
			{
				Buffer = Board[i];
				Buffer +=Totalcount;
				Place = i;
				}
			
			else if(Board[i]>Board[i+1]){
				Buffer = Board[i+1];
				Buffer +=Totalcount;
				Place = (i+1);
			}
			
		}
		
		
		return 3;
	}
	public static int thisRand(int x) {

		return generator.nextInt(x);

	}

	public static String XString() {

		for (int i = 0; i < BoardSize; i++) {
			System.out.print(Board[i]);
			System.out.print(" ");

		}
		return " ";
	}
}