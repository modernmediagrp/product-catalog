package com.sandaradura.productcatalog.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	@JoinTable(name = "category_products",
    joinColumns = { @JoinColumn(name = "category_id") },
    inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Product> products;

	@NotNull
	private String description;

	private Date createdOrModifiedDate;
	
	private String createdOrModifiedBy;
	
	public Category() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOrModifiedDate() {
		return createdOrModifiedDate;
	}

	public void setCreatedOrModifiedDate(Date createdOrModifiedDate) {
		this.createdOrModifiedDate = createdOrModifiedDate;
	}

	public String getCreatedOrModifiedBy() {
		return createdOrModifiedBy;
	}

	public void setCreatedOrModifiedBy(String createdOrModifiedBy) {
		this.createdOrModifiedBy = createdOrModifiedBy;
	}	
}
