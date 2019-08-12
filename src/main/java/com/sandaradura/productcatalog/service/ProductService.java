package com.sandaradura.productcatalog.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sandaradura.productcatalog.model.Product;
import com.sandaradura.productcatalog.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public Product saveProduct(@Valid Product product) {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		product.setCreatedOrModifiedBy(username);
		product.setCreatedOrModifiedDate(new Date());
		return productRepository.save(product);
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
		
	}

	public Product updateProduct(long id, Product product) {
		product.setId(id);
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		product.setCreatedOrModifiedBy(username);
		product.setCreatedOrModifiedDate(new Date());
		return productRepository.save(product);
	}

}
