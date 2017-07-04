package edu.cpp.cs356.assignment1;

import java.util.BitSet;

public class MultiSelectionQuestion extends MultipleChoiceQuestion{

	public MultiSelectionQuestion(String prompt, String[] choices) {
		super(prompt, choices);
	}

	@Override
	public void answer(String studentID, Answer answer) {
		if ( answers.containsKey(studentID) ){
			removeOldAnswers(answers.get(studentID));
		}
		answers.put(studentID, answer);
		BitSet choices = ((MultiSelectionAnswer)answer).getChoices();
		for ( int i = 0; i < choices.length(); i++){
			if ( choices.get(i) ){
				answerResults[i]++;
			}
		}
	}
	
	private void removeOldAnswers( Answer answer ){
		BitSet choices = ((MultiSelectionAnswer)answer).getChoices();
		for ( int i = 0; i < choices.length(); i++){
			if ( choices.get(i) ){
				answerResults[i]--;
			}
		}
	}

	@Override
	public Answer getAnswerInstance() {
		return new MultiSelectionAnswer( super.getNumChoices() );
	}

}
