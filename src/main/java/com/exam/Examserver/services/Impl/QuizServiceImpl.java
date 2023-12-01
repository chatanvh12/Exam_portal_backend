package com.exam.Examserver.services.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Examserver.Repository.QuizRepository;
import com.exam.Examserver.entity.Category;
import com.exam.Examserver.entity.Quiz;
import com.exam.Examserver.services.QuizeService;
@Service
public class QuizServiceImpl implements QuizeService{

	@Autowired
	private QuizRepository quizrepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizrepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizrepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<>(this.quizrepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.quizrepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz quiz=new Quiz();
		quiz.setqId(quizId);
		
		this.quizrepository.delete(quiz);
		
	}

	@Override
	public List<Quiz> getQuizzeOfCategory(Category category) {
		
		return this.quizrepository.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizes() {
	
		return this.quizrepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizrepository.findByCategoryAndActive(category, true );
	}

}
