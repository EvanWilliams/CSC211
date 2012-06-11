package edw.emich.CSC211.ewilli46.IOlabPart1;

import java.io.*;

public class NoDuplicates {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		String s;
//		Try Statement to make sure that both files are accepted
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(
					"./ExtraSpaces.txt"));
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(
					"./NoExtraSpaces.txt"));

			int count = 0;
			String line = inputStream.readLine();
			while (line != null) {
				count++;
				s = RemoveWhitespace(line);
				outputStream.println(count + ")" + s);
				System.out.println(count + ")" + s);
				line = inputStream.readLine();
			}
//		Closing both streams at the end of the progr am..
			inputStream.close();
			outputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("problem opening files.");

		} catch (IOException e) {
			System.out.println("Error reading from original.txt");
		}
	}
//		I thought to make a method that handled removing the extra "white space" from the given line of text, Saved as a
//		String temporarily. THis works by finding two instances of ' '.
	public static String RemoveWhitespace(String s) {
		int First, len, Second;
		len = s.length();
//		THe second starts scanning from the index after the First instanceOf 
		First = s.indexOf(' ');
		Second = s.indexOf(' ', First + 1);
//		NOw this is a bit screwy but i got it to work. I made the First index defined as the index of the Second-1
//		, and the Second as the First-1. This made my program work so that after the extra white space was 
//		effectively deleted I would not get stuck in a place where First=1 and SEcond =4 and the ' ' at index 4 
//		will always remain this taking that instance first.
		do {
			First = s.indexOf(' ', Second - 1);
			Second = s.indexOf(' ', First + 1);
			for (int i = 0; i < len - 1; i++) {
//		FOr this part of the program I checked if the two instances of ' ' were in adjacent index places and deleted 
//		the one that was farthest to the right of the string.
				while (Second == First + 1) {
					s = s.substring(0, First + 1)
							+ s.substring(Second + 1, len);
					len = s.length();
					First = s.indexOf(' ');
					Second = s.indexOf(' ', (First + 1));
				}
			}
//		Although this program may run a bit more times than it may necessarily need to it will stop the loop if there is
//		any index value returned as a -1
		} while (Second != -1 && First != -1);
//		returns a new string also named "s" since strings r immutable!!!
		return s;

	}
}

//OUTPUT:
//1)Abc
//2) 123 w q a
//3) s e w
//4) ss df s
//5) Now is the time for all
//6) good people to come to the
//7) aid of their computers. 
