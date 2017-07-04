package edu.cpp.cs356.assignment1;

import java.util.BitSet;

public class MultiSelectionAnswer implements Answer {

	private BitSet choices;
	
	public MultiSelectionAnswer( int numChoiceOptions ){
		choices = new BitSet(numChoiceOptions);
	}
	
	@Override
	public void select(int choice) {
		if ( choice >= 0 || choice < choices.length() )
			choices.set(choice);
		else
			throw new RuntimeException("Invalid Selection");
	}
	 
	public void unselect(int choice){
		if ( choice >= 0 || choice < choices.length() )
			choices.clear(choice);
		else
			throw new RuntimeException("Invalid Selection");
	}
	
	public BitSet getChoices(){
		return choices;
	}
}
