package edw.emich.CSC211.ewilli46.IOlabPart1;

import java.io.*;

public class NoDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
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
			inputStream.close();
			outputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("problem opening files.");

		} catch (IOException e) {
			System.out.println("Error reading from original.txt");
		}
	}

	public static String RemoveWhitespace(String s) {
		int First, len, Second;
		len = s.length();
		First = s.indexOf(' ');
		Second = s.indexOf(' ', First + 1);
		do {
			First = s.indexOf(' ', Second - 1);
			Second = s.indexOf(' ', First + 1);
			for (int i = 0; i < len - 1; i++) {

				while (Second == First + 1) {
					s = s.substring(0, First + 1)
							+ s.substring(Second + 1, len);
					len = s.length();
					First = s.indexOf(' ');
					Second = s.indexOf(' ', (First + 1));
				}
			}
		} while (Second != -1 && First != -1);
		// String s2 = s;
		return s;

	}
}