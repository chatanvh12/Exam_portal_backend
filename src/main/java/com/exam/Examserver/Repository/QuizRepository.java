package com.exam.Examserver.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.Examserver.entity.Category;
import com.exam.Examserver.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long>{
   public List<Quiz> findBycategory(Category category);
   
   public List<Quiz> findByActive(Boolean b);
   public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
