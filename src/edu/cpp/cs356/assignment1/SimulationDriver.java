package edu.cpp.cs356.assignment1;

import java.util.Random;

public class SimulationDriver {
	public static void main(String[] args){
		Random rand = new Random();
		IVoteService service = IVoteService.getIVoteService();
		
		addQuestions( service);
		System.out.println(service.getQuestionsAndResultsString());
		
		Question[] questions = service.getQuestions();
		Student[][] students = new Student[questions.length][25];
		
		// 25 students are generated for each question
		for (int i = 0; i < questions.length; i++) {
			for (int j = 0; j < students[i].length; j++) {
				Student s = new Student();
				s.connectToIVoteService(service);
				s.selectQuestion(questions[i]);
				students[i][j] = s;
			}
		}
		
		// Each students marks two random choices, and submits their answer
		// For single choice questions, only the second one will count.
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[i].length; j++) {
					Student s = students[i][j];
					Question q = s.getSelectedQuestion();
					s.getAnswer().select(rand.nextInt(q.getNumChoices()));
					s.getAnswer().select(rand.nextInt(q.getNumChoices()));
					s.submitAnswer();
			}
		}
		
		System.out.println(service.getQuestionsAndResultsString());
		
	}

	private static void addQuestions(IVoteService service) {
		String q1Prompt = "Which of the follwing foods is the best?";
		String[] q1Choices = {"Hamburger", "Pizza", "Ice Cream", "Sushi", "Steak" };
		Question q1 = new SingleSelectionQuestion(q1Prompt, q1Choices);
		
		String q2Prompt = "Flat is justice?";
		String[] q2Choices = {"Yes", "Yes" };
		Question q2 = new SingleSelectionQuestion(q2Prompt, q2Choices);
		
		String q3Prompt = "What are your interests? (Mark all that apply)";
		String[] q3Choices = {"Programming", "Eating Food", "Cars", "Motorcycles", "Basketball", "Soccer", 
								"Chinese Cartoons", "Firearms/Shooting", "Video Games", "Music"};
		Question q3 = new MultiSelectionQuestion(q3Prompt, q3Choices);
		
		service.addQuestion(q1);
		service.addQuestion(q2);
		service.addQuestion(q3);
	}
}
