package com.sandaradura.productcatalog.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sandaradura.productcatalog.model.Category;
import com.sandaradura.productcatalog.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")	
	@GetMapping("/product-catalog/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = categoryService.findAll();	
		return ResponseEntity.ok(categories);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/product-catalog/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
		Category category = categoryService.findById(id);
		return ResponseEntity.ok(category);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/product-catalog/categories")
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
		Category savedCategory = categoryService.saveCategory(category);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCategory.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/product-catalog/categories/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/product-catalog/categories/{id}")
	public void updateCategory(@PathVariable long id, @RequestBody Category category) {
		categoryService.updateCategory(id, category);
	}

}
