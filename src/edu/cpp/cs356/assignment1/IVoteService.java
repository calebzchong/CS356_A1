package edu.cpp.cs356.assignment1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class IVoteService {
	private static IVoteService service = new IVoteService();
	private Hashtable<String, Student> students;
	private List<Question> questions;

	//Singleton
	private IVoteService(){
		students = new Hashtable<>();
		questions = new ArrayList<>();
	}

	public String addStudent( Student s ){
		String id = getNewStudentID();
		students.put(id, s);
		return id;
	}
	
	public String getNewStudentID(){
		String id;
		do {
			id = IDGenerator.getRandomID(10);
		} while ( students.containsKey(id));
		return id;
	}
	
	public static IVoteService getIVoteService(){
		return service;
	}

	public void addQuestion( Question q ){
		questions.add( q );
	}
	
	public Question[] getQuestions( ){
		return questions.toArray(new Question[questions.size()]);
	}
	
//	public String getNewQuestionID(){
//		String id;
//		do {
//			id = IDGenerator.getRandomID(5);
//		} while ( questions.containsKey(id));
//		return id;
//	}

	public String getQuestionsAndResultsString(){
		StringBuilder sb = new StringBuilder();
		for ( Question q : questions) {
			sb.append("Question\n");
			sb.append( q );
			sb.append("Results:\n");
			sb.append( q.getResults());
			sb.append("\n");
		}
		return sb.toString();
	}


}
