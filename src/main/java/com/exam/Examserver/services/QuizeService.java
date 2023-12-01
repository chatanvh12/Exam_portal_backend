package com.exam.Examserver.services;

import java.util.List;
import java.util.Set;

import com.exam.Examserver.entity.Category;
import com.exam.Examserver.entity.Quiz;

public interface QuizeService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);
	public List<Quiz> getQuizzeOfCategory(Category category);
     
	public List<Quiz> getActiveQuizes();
	public List<Quiz> getActiveQuizesOfCategory(Category category);
}
