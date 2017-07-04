package edu.cpp.cs356.assignment1;

public class SingleSelectionQuestion extends MultipleChoiceQuestion {
	
	public SingleSelectionQuestion(String prompt, String[] choices) {
		super(prompt, choices);
	}

	@Override
	public void answer(String studentID, Answer answer) {
		if ( answers.containsKey(studentID) ){
			int prevChoice = ((SingleSelectionAnswer)answers.get(studentID)).getChoice();
			answerResults[prevChoice]--;
		}
		answers.put(studentID, answer);
		int choice = ((SingleSelectionAnswer)answer).getChoice();	
		answerResults[choice]++;
	}

	@Override
	public Answer getAnswerInstance() {
		return new SingleSelectionAnswer( super.getNumChoices() );
	}
	
}
