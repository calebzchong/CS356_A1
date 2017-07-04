package edu.cpp.cs356.assignment1;

public class Student {
	private String studentID;
	private Question selectedQuestion;
	private IVoteService service;
	private Answer answer;
	
	public void connectToIVoteService( IVoteService service ){
		this.studentID = service.addStudent(this);
		this.service = service;
	}
	 
	public void selectQuestion( Question q ){
		if ( service != null ){
			selectedQuestion = q;
			answer = selectedQuestion.getAnswerInstance();
		}
	}
	
	public void submitAnswer(){
		selectedQuestion.answer(studentID, answer);
	}
	
	public Answer getAnswer(){
		return answer;
	}
	
	public Question getSelectedQuestion(){
		return selectedQuestion;
	}

}
