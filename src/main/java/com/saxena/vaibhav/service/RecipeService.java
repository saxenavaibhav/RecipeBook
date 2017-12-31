package com.saxena.vaibhav.service;

/**
 * Created by Vaibhav Saxena.
 */

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.saxena.vaibhav.command.RecipeCommand;
import com.saxena.vaibhav.converter.RecipeCommandToRecipe;
import com.saxena.vaibhav.converter.RecipeToRecipeCommand;
import com.saxena.vaibhav.domain.Recipe;
import com.saxena.vaibhav.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");

		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	public Recipe findById(Long l) {

		Optional<Recipe> recipeOptional = recipeRepository.findById(l);

		if (!recipeOptional.isPresent()) {
			throw new RuntimeException("Recipe Not Found!");
		}

		return recipeOptional.get();
	}

	@Transactional
	public RecipeCommand findCommandById(Long l) {
		return recipeToRecipeCommand.convert(findById(l));
	}

	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

		Recipe savedRecipe = recipeRepository.save(detachedRecipe);
		log.debug("Saved RecipeId:" + savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	public void deleteById(Long idToDelete) {
		recipeRepository.deleteById(idToDelete);
	}
}
