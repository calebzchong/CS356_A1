package edu.cpp.cs356.assignment1;

import java.util.Hashtable;

public abstract class MultipleChoiceQuestion implements Question {

	private String prompt;
	private String[] choices;
	protected int[] answerResults;
	protected Hashtable<String, Answer> answers;
	
	public MultipleChoiceQuestion( String prompt, String[] choices ){
		this.prompt = prompt;
		this.choices = choices;
		this.answerResults = new int[choices.length];
		answers = new Hashtable<>();
	}

	public int getNumChoices(){
		return choices.length;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(prompt + "\n");
		for ( int i = 0; i < choices.length; i++){
			sb.append(" " + (char)(65+i));
			sb.append(". ");
			sb.append(choices[i]);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getResults(){
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < choices.length; i++){
			sb.append(" " + (char)(65+i) + " : " + answerResults[i] + "\n");
		}
		return sb.toString();
	}

}
