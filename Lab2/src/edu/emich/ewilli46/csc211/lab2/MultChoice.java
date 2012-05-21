package edu.emich.ewilli46.csc211.lab2;

import java.util.Scanner;

public class MultChoice extends TestQuestion {

	int nOfCs = 0;
	String Cs[];

	MultChoice(Scanner scan) {
		super();
		nOfCs = scan.nextInt();

		Cs = new String[nOfCs];
		scan.nextLine();// ignore blank line
		setQuestion(scan.nextLine());
		setQuestionType('m');

		for (int i = 0; i < nOfCs; i++) {
			Cs[i] = scan.nextLine();
		}

	}

	public String toString() {
		String sOut = null;
		final char Choices[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z' };
		
		// Maximum of 26 choices
		sOut = getQuestion() + "\n";

		for (int j = 0; j < nOfCs; j++) {
			sOut += "\t" + (Choices[j]) + ") " + Cs[j];
			sOut += "\n";
		}

		return sOut;

	}

}
