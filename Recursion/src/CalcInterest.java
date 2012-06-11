import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcInterest {
	static double balance = 0;
	static double rate = 0;
	static double years = 0;
	public static boolean continueLoop;

	public static void main(String[] args) {
		double n1 = 0;
		double d1 = 0;
		double d2 = 0;
		continueLoop = true;

		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out
				.println("Enter an integer that represents your account balance : ");
				n1 = scan.nextDouble();
				balance = n1;
				System.out
				.println("Enter a double that represents your account intrest rate as a decimal of 1: ");
				System.out.println("For example .1 for 10%");
				d1 = scan.nextDouble();
				rate = d1;
				System.out
				.println("Enter a double that represents how many years you want to project : ");
				d2 = scan.nextDouble();
				years = d2;
				continueLoop = false;
				calcSavings(n1, d1, d2);
				System.out.print("The accrued savings after " + d2);
				System.out.print(" years at " + (d1 * 100) + "% is : ");
				System.out.printf("%.2f", balance);
			}

			catch (InputMismatchException e) {
				System.out
				.println("one of both of your integers is invalid \n");
				scan.nextLine();

			}

		} while (continueLoop == true);
	}

	public static void calcSavings(double b, double r, double y) {
		balance = b;
		rate = r;
		years = y;

		if (y > 0) {
			balance = (balance * (1 + rate));
			b = balance;
			y = years;
			calcSavings(b, r, y - 1);
		}
	}

}
