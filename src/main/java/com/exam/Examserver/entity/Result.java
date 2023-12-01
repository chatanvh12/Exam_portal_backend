package com.exam.Examserver.entity;

import java.util.LinkedList;
import java.util.List;

public class Result {
	
	private int attempted;
	private int correctAnswer;
	private int totalQuestions;
    private List<String> lst = new LinkedList<>();
	
	public Result() {
		
	}

	public Result(int attempted, int correctAnswer, int totalQuestions, List<String> lst) {
		super();
		this.attempted = attempted;
		this.correctAnswer = correctAnswer;
		this.totalQuestions = totalQuestions;
		this.lst = lst;
	}

	public int getAttempted() {
		return attempted;
	}

	public void setAttempted(int attempted) {
		this.attempted = attempted;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public List<String> getLst() {
		return lst;
	}

	public void setLst(List<String> lst) {
		this.lst = lst;
	}
	
}