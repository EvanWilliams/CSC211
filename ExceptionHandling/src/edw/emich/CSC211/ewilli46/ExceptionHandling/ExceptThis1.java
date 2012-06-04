//package edw.emich.CSC211.ewilli46.ExceptionHandling;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class ExceptThis1 {
//
//	public static void returnRatio()throws InputMismatchException {
//
//		Scanner scan = new Scanner( System.in); 
//		int n1, n2; 
//		double r;{ 
//			n1 = scan.nextInt(); 
//			n2 = scan.nextInt(); 
//			r = ( double) n1 / n2; 
//
//		}
//
//		public static void main(String[] args)
//		{
//			
//			boolean hasNotEnteredTwoNumbers = true;
//			do {
//				System.out.println("Enter two integers separated by a new line. ");
//				try {
//					n1 = scan.nextInt();
//					System.out.println("The First integer is : " + n1 + "\n");
//					n2 = scan.nextInt();
//					System.out.println("The Second integer is : " + n2 + "\n");
//					r = (double) n1 / n2;
//					System.out.println("The Quotient of n1 and n2 is : " + r);
//					hasNotEnteredTwoNumbers = false;
//
//				} catch (InputMismatchException e) {
//					System.out.println("one of both of your integers is invalid \n");
//
//				} finally {
//					scan.nextLine();
//				}
//			} while (hasNotEnteredTwoNumbers);
//		}
//		//	Output using returnRatio:Enter two integers separated by a new line. 
//		//	f
//		//	one of both of your integers is invalid 
//		//
//		//	Enter two integers separated by a new line. 
//		//	g
//		//	one of both of your integers is invalid 
//		//
//		//	Enter two integers separated by a new line. 
//		//	z
//		//	one of both of your integers is invalid 
//		//
//		//	Enter two integers separated by a new line. 
//		//	111
//		//	The First integer is : 111
//		//
//		//	222
//		//	The Second integer is : 222
//		//
//		//	The Quotient of n1 and n2 is : 0.5
//
//		//	Output:
//		//Enter two integers separated by a new line. 
//		//	f
//		//	one of both of your integers is invalid 
//		//
//		//	Enter two integers separated by a new line. 
//		//	49
//		//	The First integer is : 49
//		//
//		//	126
//		//	The Second integer is : 126
//		//
//		//	The Quotient of n1 and n2 is : 0.3888888888888889
//
//	}
//}
