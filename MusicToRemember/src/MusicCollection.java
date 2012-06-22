import java.util.InputMismatchException;
import java.util.Scanner;


public class MusicCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int Count = 0;
		  String[] List;
		Scanner keyboard = new Scanner(System.in);
		try{
		//Intro
		System.out.println("Music Collection Software");
		System.out.println("Enter The Number of songs you would like to store : ");
		Count = keyboard.nextInt();
		System.out.println("This Program will create a list of "+Count+" songs" );
		
		}
		catch(InputMismatchException e){
			keyboard.nextLine();
			System.out.println("That is not a number.");
			System.out.println("----------------------------------------------------");
		}
		List = new String[Count] ;
		String buffer;
		
		for (int i=0;i<Count;i++){ 
		System.out.println("Enter the Artist and the name of the Song.");
		System.out.println("------------------Press Enter---------------------");
		buffer = keyboard.nextLine( );
		List [i] = buffer;
		}
		
		for (int i=0;i<Count;i++){
			System.out.println(i+")"+List[i]);
		}
	}

}
