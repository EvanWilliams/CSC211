package edu.emich.ewilli46.csc211.lab2;

abstract class TestQuestion {

	protected String question;

	int blankSpace;

	// Getters and Setters
	char questionType;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getBlankSpace() {
		return blankSpace;
	}

	public void setBlankSpace(int blankSpace) {
		this.blankSpace = blankSpace;
	}

	/**
	 * @return a Type of Question(Essay or MultChoice)
	 */
	public char getQuestionType() {
		return questionType;
	}

	public void setQuestionType(char questionType) {
		this.questionType = questionType;
	}

	TestQuestion() {
		question = null;
		blankSpace = 0;
		questionType = '?';
	}

}
