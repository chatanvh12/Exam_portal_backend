package com.exam.Examserver.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.Examserver.entity.Question;
import com.exam.Examserver.entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
