package edu.cpp.cs356.assignment1;

public interface Question {
	public void answer( String studentID, Answer answer );
	public String toString();
	public String getResults();
	public int getNumChoices();
	public Answer getAnswerInstance();
}
