package com.exam.Examserver.services;

import java.util.Set;

import com.exam.Examserver.entity.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getcategorys();
	public Category getCategory(Long categoryId);
	public void deteCategory(Long categoryId);
	
	
}
