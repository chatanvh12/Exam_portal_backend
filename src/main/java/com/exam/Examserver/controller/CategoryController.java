package com.exam.Examserver.controller;


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
import com.exam.Examserver.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category category1=this.categoryservice.addCategory(category);
		return ResponseEntity.ok(category1);	
	}
	
	//get Category
	@GetMapping("/{categoryId}")
	public Category getAllCategory(@RequestBody Long categoryId){
		return this.categoryservice.getCategory(categoryId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getCategory(){
		return ResponseEntity.ok(this.categoryservice.getcategorys());
		
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryservice.updateCategory(category);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		this.categoryservice.deteCategory(categoryId);
	}
	
}
