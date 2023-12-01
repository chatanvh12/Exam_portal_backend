package com.exam.Examserver.services;

import java.util.Set;

import com.exam.Examserver.entity.Question;
import com.exam.Examserver.entity.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestions();
	public Question getQuestion(Long qId);
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	public void deleteQuestion(Long qId);

}
