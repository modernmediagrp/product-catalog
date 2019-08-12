package com.sandaradura.productcatalog.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sandaradura.productcatalog.model.Product;
import com.sandaradura.productcatalog.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/product-catalog/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		Product savedProduct = productService.saveProduct(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/product-catalog/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/product-catalog/products/{id}")
	public void updateProduct(@PathVariable long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
	}
	
}
