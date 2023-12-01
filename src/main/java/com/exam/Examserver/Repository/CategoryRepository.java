package com.exam.Examserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.Examserver.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	
}
