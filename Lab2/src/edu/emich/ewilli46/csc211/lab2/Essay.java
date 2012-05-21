package edu.emich.ewilli46.csc211.lab2;

import java.util.Scanner;

public class Essay extends TestQuestion {

	Essay(Scanner scan) {
		super();
		setBlankSpace(scan.nextInt());
		scan.nextLine(); // ignore extra line
		setQuestion(scan.nextLine());
		setQuestionType('e');
	}

	public String toString() {
		String sOut = null;

		sOut = getQuestion() + "\n";
		for (int j = 0; j < getBlankSpace(); j++) {
			sOut += "\n";
		}

		return sOut;

	}

}