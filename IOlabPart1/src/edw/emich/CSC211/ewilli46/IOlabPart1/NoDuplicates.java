package edw.emich.CSC211.ewilli46.IOlabPart1;

import java.io.*;

public class NoDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			BufferedReader inputStream = new BufferedReader(
					new FileReader(
							"C:/temp/ExtraSpaces"));
			PrintWriter outputStream = new PrintWriter(
					new FileOutputStream(
							"C:/temp/NoExtraSpaces"));

			int count = 0;
			String line = inputStream.readLine();
			while (line != null)
			{
				count++;
				RemoveWhitespace(line);
				outputStream.println(count + " " + line);
				line = inputStream.readLine();
			}
			inputStream.close();
			outputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("problem opening files.");
			
		} catch (IOException e) {
			System.out.println("Error reading from original.txt");
		}
//		for(i=0;i<count;i++)
		
	}
	public String RemoveWhitespace(String s)
	{	
		int Second,ind,First;
		ind = s.length();
		First = s.indexOf(' ');
		if(First !=-1)
			while(First<ind)
		Second = s.indexOf(' ',First+1);
		
		
		}
}