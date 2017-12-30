package com.saxena.vaibhav.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.saxena.vaibhav.command.RecipeCommand;
import com.saxena.vaibhav.converter.RecipeCommandToRecipe;
import com.saxena.vaibhav.converter.RecipeToRecipeCommand;
import com.saxena.vaibhav.domain.Recipe;
import com.saxena.vaibhav.repository.RecipeRepository;

public class RecipeServiceTest {

	RecipeService recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeService(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}
	
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<Recipe>();
		recipeData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}
	
	@Test
	public void testGetRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
		Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
	}

	  @Test
	    public void getRecipeCoomandByIdTest() throws Exception {
	        Recipe recipe = new Recipe();
	        recipe.setId(1L);
	        Optional<Recipe> recipeOptional = Optional.of(recipe);

	        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

	        RecipeCommand recipeCommand = new RecipeCommand();
	        recipeCommand.setId(1L);

	        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

	        RecipeCommand commandById = recipeService.findCommandById(1L);

	        assertNotNull("Null recipe returned", commandById);
	        verify(recipeRepository, times(1)).findById(anyLong());
	        verify(recipeRepository, never()).findAll();
	    }

	    @Test
	    public void getRecipesTest() throws Exception {

	        Recipe recipe = new Recipe();
	        HashSet receipesData = new HashSet();
	        receipesData.add(recipe);

	        when(recipeRepository.findAll()).thenReturn(receipesData);

	        Set<Recipe> recipes = recipeService.getRecipes();

	        assertEquals(recipes.size(), 1);
	        verify(recipeRepository, times(1)).findAll();
	        verify(recipeRepository, never()).findById(anyLong());
	    }
}
