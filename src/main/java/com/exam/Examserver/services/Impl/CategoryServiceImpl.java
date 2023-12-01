package com.exam.Examserver.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Examserver.Repository.CategoryRepository;
import com.exam.Examserver.entity.Category;
import com.exam.Examserver.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryrepository;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryrepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryrepository.save(category);
	}

	@Override
	public Set<Category> getcategorys() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>( this.categoryrepository.findAll());
	}

	@Override
	public void deteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category =new Category();
		category.setcId(categoryId);
		this.categoryrepository.delete(category);
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return this.categoryrepository.findById(categoryId).get();
	}

}
