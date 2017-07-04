package edu.cpp.cs356.assignment1;

public class SingleSelectionAnswer implements Answer {
	
	private Integer choice;
	private int numChoiceOptions;
	
	public SingleSelectionAnswer( int numChoiceOptions ){
		this.numChoiceOptions = numChoiceOptions;
	}
	
	@Override
	public void select(int choice) {
		if ( choice >= 0 && choice < numChoiceOptions )
			this.choice = choice;
		else
			throw new RuntimeException("Invalid Selection");
	}
	
	public int getChoice(){
		return choice;
	}

}
