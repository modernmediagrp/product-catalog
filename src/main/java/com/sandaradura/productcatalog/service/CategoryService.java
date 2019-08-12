package com.sandaradura.productcatalog.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sandaradura.productcatalog.exception.CategoryNotFoundException;
import com.sandaradura.productcatalog.model.Category;
import com.sandaradura.productcatalog.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category saveCategory(@Valid Category category) {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		category.setCreatedOrModifiedBy(username);
		category.setCreatedOrModifiedDate(new Date());
		return categoryRepository.save(category);
	}

	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

	public Category updateCategory(long id, Category category) {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		category.setId(id);
		category.setCreatedOrModifiedBy(username);
		category.setCreatedOrModifiedDate(new Date());
		return categoryRepository.save(category);

	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (!category.isPresent()) {
			throw new CategoryNotFoundException(String.format("Category not found category id:{} ", id));
		}
		return category.get();
	}

}
