package com.saxena.vaibhav.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.saxena.vaibhav.domain.Recipe;
import com.saxena.vaibhav.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeService {

	private RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		log.info("Test logger in recipe Service");
		return recipeSet;
	}
	
	public Recipe findById(Long id) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(id);
		if (!recipeOptional.isPresent()) {
			throw new RuntimeException("No recipe with teh given ID.");
		}
		return recipeOptional.get();
	}
	
}
