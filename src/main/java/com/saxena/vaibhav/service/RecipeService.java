package com.saxena.vaibhav.service;

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

	private RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
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
			throw new RuntimeException("No recipe with the given ID.");
		}
		return recipeOptional.get();
	}
	
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
    
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }
}
