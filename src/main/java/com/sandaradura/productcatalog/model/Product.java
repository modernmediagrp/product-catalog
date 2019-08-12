package com.sandaradura.productcatalog.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private Set<Category> categories;
	
	@NotNull	
	private String description;
	
	@NotNull
	private Integer quantity;
	
	private Date createdOrModifiedDate;
	
	private String createdOrModifiedBy;
	
	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
