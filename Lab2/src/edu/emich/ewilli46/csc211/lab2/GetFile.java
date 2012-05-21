package edu.emich.ewilli46.csc211.lab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Evan Williams E00887504 This is a program that reads in a coded set of
 * questions from a text file and displays them in order. ex. Question1,
 * Question2...
 * 
 */
public class GetFile {

	public static void main(String args[]) throws FileNotFoundException {

		Scanner scan = null;
		scan = new Scanner(new FileInputStream(
				"C:/Projects/CSC211/Lab2(prelab)/Data/testbank.dat"));
		// Scans in the data from the text file
		int nOfQs = scan.nextInt();
		// First int is the number of Questions in the test

		TestQuestion TQs[] = new TestQuestion[nOfQs];

		for (int i = 0; i < nOfQs; i++) {
			TQs[i] = readQuestion(scan);
		}

		WriteTest wt = new WriteTest(TQs);
		wt.doWriteTest();

		System.out.println("");
	}

	// This method reads the character that determines if the next question is
	// multiple choice or an essay question
	// and puts in in a temporary location so it can store and label it in the
	// Array of TestQuestions named TQs

	static TestQuestion readQuestion(Scanner scan) {
		String type = scan.next();

		if (type.equals("m")) {
			MultChoice m1 = new MultChoice(scan);
			return (m1);
		} else if (type.equals("e")) {
			Essay e1 = new Essay(scan);
			return (e1);
		}
		return (null);
	}
}
// Output
// ------------------------------------------------------------
// Question Number: 1
// Why does the constructor of a derived class have to call the constructor of
// its parent class?
//
//
//
//
//
//
// ------------------------------------------------------------
// Question Number: 2
// Which of the following is not a legal identifier in Java?
// a)guess2
// b)2ndGuess
// c)_guess2_
// d)Guess
//
// ------------------------------------------------------------
// Question Number: 3
// How do interfaces provide polymorphism in Java?
//
//
//
//
//
//
//
//
//
//
//
// ------------------------------------------------------------
// Question Number: 4
// Java does not support multiple inheritance. This means that a class cannot do
// what?
//
//
//
//
// ------------------------------------------------------------
// Question Number: 5
// A JPanel has an <i>addMouseListener</i> method because JPanel is a subclass
// of
// a)JComponent
// b)JApplet
// c)Object

