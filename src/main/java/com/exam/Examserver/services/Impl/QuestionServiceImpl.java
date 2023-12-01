package com.exam.Examserver.services.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Examserver.Repository.QuestionRepository;
import com.exam.Examserver.entity.Question;
import com.exam.Examserver.entity.Quiz;
import com.exam.Examserver.services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionRepository questionreposit;

	@Override
	public Question addQuestion(Question question) {
		return this.questionreposit.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionreposit.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionreposit.findAll());
	}

	@Override
	public Question getQuestion(Long qId) {
		return this.questionreposit.findById(qId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionreposit.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long qId) {
		// TODO Auto-generated method stub
		Question question=new Question();
		question.setQuesId(qId);
		this.questionreposit.delete(question);
	}

	
	
	

}
