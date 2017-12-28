package com.saxena.vaibhav.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Ingredient {

	public Ingredient() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	
	private BigDecimal amount;

	@OneToOne
	private UnitOfMeasure uom;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
	        this.description = description;
	        this.amount = amount;
	        this.uom = uom;
	        this.recipe = recipe;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public BigDecimal getAmount() {
//		return amount;
//	}
//
//	public void setAmount(BigDecimal amount) {
//		this.amount = amount;
//	}
//
//	public Recipe getRecipe() {
//		return recipe;
//	}
//
//	public void setRecipe(Recipe recipe) {
//		this.recipe = recipe;
//	}
//
//	public UnitOfMeasure getUom() {
//		return uom;
//	}
//
//	public void setUom(UnitOfMeasure uom) {
//		this.uom = uom;
//	}

}
