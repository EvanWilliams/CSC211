package edu.emich.ewilli46.csc211.lab2;

/**
 * 
 */

public class WriteTest {
	// Declaring an Array that is cloned from TQ[]
	TestQuestion Bn[];

	WriteTest(TestQuestion inTQ[]) {
		Bn = inTQ;
	}

	void doWriteTest()
	// This method displays the Question prefix common to all TestQuestions
	// This includes a dashed line for formating, Question and the Question
	// Number
	{
		int n = Bn.length;
		String outputString = null;

		for (int i = 0; i < n; i++) {
			char Qtype = Bn[i].getQuestionType();
			// Dash Line for formatting
			outputString = "------------------------------------------------------------\n";
			outputString += "Question Number: " + (i + 1) + " \n";
			switch (Qtype)
			// Once Question prefix have been entered this WriteTest Class
			// determines what type of question each Question is
			// and uses the appropriate toString Method(in Essay and MultChoice
			// classes respectively)
			{
			case 'm':
				outputString += ((MultChoice) Bn[i]).toString();
				break;

			case 'e':
				outputString += ((Essay) Bn[i]).toString();
				break;
			}
			System.out.println(outputString);
		}
	}
}
