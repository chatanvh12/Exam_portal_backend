package com.exam.Examserver.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

import com.exam.Examserver.entity.Question;
import com.exam.Examserver.entity.Quiz;
import com.exam.Examserver.entity.Result;
import com.exam.Examserver.services.QuestionService;
import com.exam.Examserver.services.QuizeService;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionservice;
	
	@Autowired
	private QuizeService quizeservice;
	
	//Add question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question questions){
		System.out.println(questions.getQuiz().getqId()+" "+questions.getQuesId()+" /"+questions.getCoutent()+" /"+questions.getImage()+" "+questions.getOption1()+" "+questions.getOption2()+" "+questions.getOption3()+" "+questions.getOption4()+" "+questions.getAnswer()   +" answers");
		return ResponseEntity.ok(this.questionservice.addQuestion(questions));
	}
    //update the question
	
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(this.questionservice.updateQuestion(question));
	}
	
	//get question of quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getquestionsOfQuiz(@PathVariable Long quizId){
		System.out.println(quizId);
		Quiz quiz=this.quizeservice.getQuiz(quizId);
		Set<Question> question=quiz.getQuestion();
		List<Question> list=new ArrayList<Question>(question);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
		Quiz q1=new Quiz();
		q1.setqId(qid);
		return ResponseEntity.ok(this.questionservice.getQuestionsOfQuiz(q1));
	}
	
	//get single question
	@GetMapping("/{qId}")
	public Question getSingleQuestion(@PathVariable Long qId) {
		return this.questionservice.getQuestion(qId);
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable Long quesId) {
		this.questionservice.deleteQuestion(quesId);
	}
	@PostMapping("/eval-quiz/{qId}")
	public Result evaluate(@RequestBody List<Question> lst,@PathVariable int qId) {
		System.out.println(lst);
		int correctAnswer = 0;
		int attempted = 0;
		int totalQuestion =0;
		List<String> lst1=new LinkedList<>();
		for(int i=0;i<lst.size();i++) {
			lst1.add(this.questionservice.getQuestion(lst.get(i).getQuesId()).getAnswer());
			System.out.println(lst1);
			if(lst.get(i).getAnswer()!=null) {
				System.out.println(lst.get(i).getAnswer()+" "+this.questionservice.getQuestion(lst.get(i).getQuesId()).getAnswer());
				if(lst.get(i).getAnswer().equals(this.questionservice.getQuestion(lst.get(i).getQuesId()).getAnswer())) {
					correctAnswer++;
				}
				attempted++;
			}
		}
		totalQuestion=lst.size();
		System.out.println(correctAnswer+" "+attempted);
		System.out.println(lst1);
		Result r=new Result(attempted, correctAnswer,totalQuestion,lst1);
		return r;
	}
}
