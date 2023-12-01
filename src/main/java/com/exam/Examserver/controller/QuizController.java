package com.exam.Examserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Examserver.entity.Category;
import com.exam.Examserver.entity.Quiz;
import com.exam.Examserver.services.QuizeService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizeService quizservice;
	
	//add Quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		System.out.println(quiz.getCategory().getcId());
		return ResponseEntity.ok(this.quizservice.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizservice.updateQuiz(quiz));
	}
	
	//get quiz
	@GetMapping("/")
	public ResponseEntity<?> quizzes(){
		return ResponseEntity.ok(this.quizservice.getQuizzes());
	}
	
	// get single quize
	@GetMapping("/{quizId}")
	public Quiz quiz(@PathVariable Long quizId) {
		return this.quizservice.getQuiz(quizId);
	}
	
	//delete quiz
	@DeleteMapping("/{qId}")
	public void delete(@PathVariable Long qId) {
		this.quizservice.deleteQuiz(qId);
	}
    
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable Long cid){
		Category category =new Category();
		category.setcId(cid);
		return this.quizservice.getQuizzeOfCategory(category );
	}

	//get Active quiz
	@GetMapping("/active")
	public List<Quiz> getActiveQuizes(){
		return this.quizservice.getActiveQuizes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizesOfCategory(@PathVariable Long cid){
		Category category=new Category();
		category.setcId(cid);
		return this.quizservice.getQuizzeOfCategory(category);
	}
	
}
