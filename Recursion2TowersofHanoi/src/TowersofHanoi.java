import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersofHanoi {
	static boolean continueLoop = true;
	static boolean HasMoved = false;
	static Disc temp = new Disc(0);
	static int NumDisks = 4;
	static int NumPosts = 3;
	static int ToPost = 0;
	static int FromPost = 0;

	static Post scource = new Post('A', 0);
	static Post dest = new Post('B', 0);
	static Post spare = new Post('C', 0);
	static Disc top = new Disc(1);
	static Disc second = new Disc(2);
	static Disc third = new Disc(3);
	static Disc bot = new Disc(4);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		top.OnPost = scource.ToString();
		scource.topPost = 1;
		second.OnPost = scource.ToString();
		third.OnPost = scource.ToString();
		bot.OnPost = scource.ToString();
		Scanner scan = new Scanner(System.in);

		System.out.println("Hello and welcome to the Towers of Hanoi Program.");
		do {
			try {
				System.out
				.println("This Program moves Disks from one post to another.");
				System.out.println("There are 4 Disks and 3 posts.");
				System.out
				.println("Only smaller plates may sit on larger ones.");
				System.out.println("Where would you like to move?");
				System.out.println("enter an Int for the FromPost ");
				FromPost = scan.nextInt();
				System.out.println("enter an Int for the ToPost ");
				ToPost = scan.nextInt();
				System.out.println(" You want to move all of the disks from "
						+ FromPost + " to " + ToPost);
				continueLoop = false;
			}

			catch (InputMismatchException e) {
				System.out
				.println("one of both of your integers is invalid \n");
				scan.nextLine();

			}

		} while (continueLoop == true);
		System.out.println("Drawing the board");
		PrintHanoi(4, FromPost, ToPost);

	}

	public static String Print(Disc d, Post From, Post To) {
		System.out.println("Move " + d.number + " From " + From + " To " + To);
		return null;

	}

	final static Disc NextDisc(Disc d) {
		if (Disc.number == 1) {
			return (second);
		}
		if (Disc.number == 2) {
			return (third);
		}
		if (Disc.number == 3) {
			return (bot);
		}
		if (Disc.number == 4) {
			return (top);
		}
		return null;
	}

	public static char Post(char c) {
		return 'c';
		// boolean has

	}

	public static String PrintHanoi(int numDisks, int fromPost, int ToPost) {
		MoveTower(top, scource, dest, spare);
		return("complete");
	}

	public static void MoveTower(Disc d, Post Scource, Post Dest, Post Spare) {
		if (top.OnPost != ToPost && second.OnPost != ToPost && third.OnPost != ToPost
				&& bot.OnPost != ToPost) {
			if (Disc.number == 1) {
				if (Disc.OnPost == Spare.ToString()) {
					Disc.OnPost = Dest.ToString();
					HasMoved = true;
					Dest.topPost = 1;
					Print(d, Spare, Dest);
				}

				else if (Disc.OnPost == Dest.ToString()) {
					Disc.OnPost = Scource.ToString();
					HasMoved = true;
					Scource.topPost = 1;
					Print(d, Dest, Scource);
				}

				else if (Disc.OnPost == Scource.ToString()) {
					Disc.OnPost = Spare.ToString();
					HasMoved = true;
					Spare.topPost = 1;
					Print(d, Scource, Spare);
				}

				else if (Disc.number != 1) {
					if (Spare.topPost < Disc.number) {
						Disc.OnPost = Dest.ToString();
						HasMoved = true;
						Dest.topPost = Disc.number;
						Print(d, Scource, Dest);
					}

					if (Dest.topPost > Disc.number) {
						Disc.OnPost = Dest.ToString();
						HasMoved = true;
						Dest.topPost = Disc.number;
						Print(d, Spare, Dest);
					}

					else if (Dest.topPost < Disc.number) {
						Disc.OnPost = Spare.ToString();
						HasMoved = true;
						Spare.topPost = Disc.number;
						Print(d, Scource, Spare);
					}
				}
				MoveTower(NextDisc(d), Scource, Dest, Spare);
			}
		}
		return;
	}
}
