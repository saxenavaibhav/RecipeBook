package com.saxena.vaibhav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saxena.vaibhav.domain.Recipe;
import com.saxena.vaibhav.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RecipeController {

	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/show/{id}")
	public String getRecipeById(@PathVariable("id") Long id, final Model model) {
		log.info("Inside RecipeController. Recipe ID: " + id );
		Recipe recipe = recipeService.findById(id);
		model.addAttribute("recipe", recipe);
		return "recipe/show";
	}
}
