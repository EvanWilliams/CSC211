package edw.emich.CSC211.ewilli46.ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptThis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1, n2;
		boolean hasNotEnteredTwoNumbers = true;
		double r;
		do {
			System.out.println("Enter two integers separated by a new line. ");
			try {
				n1 = scan.nextInt();
				System.out.println("The First integer is : " + n1 + "\n");
				n2 = scan.nextInt();
				System.out.println("The Second integer is : " + n2 + "\n");
				r = (double) n1 / n2;
				System.out.println("The Quotient of n1 and n2 is : " + r);
				hasNotEnteredTwoNumbers = false;

				} catch (InputMismatchException e) {
				System.out
				.println("one of both of your integers is invalid \n");

				} finally {
				scan.nextLine();
			}
		} while (hasNotEnteredTwoNumbers);
	}

	// public static class returnRatio{
	//
	// Scanner scan = new Scanner( System.in);
	// int n1, n2;
	// double r;{
	// n1 = scan.nextInt();
	// n2 = scan.nextInt();
	// r = ( double) n1 / n2;
	//
	// }
	// }
}
