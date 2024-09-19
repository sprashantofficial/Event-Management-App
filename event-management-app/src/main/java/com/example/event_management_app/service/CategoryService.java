package com.example.event_management_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event_management_app.entities.Category;
import com.example.event_management_app.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	public Category getCategoryById(Long id) {
		return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
	}

	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}

}
