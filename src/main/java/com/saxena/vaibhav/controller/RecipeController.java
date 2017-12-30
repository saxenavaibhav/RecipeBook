package com.saxena.vaibhav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saxena.vaibhav.command.RecipeCommand;
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

	@RequestMapping("/recipe/{id}/show")
	public String getRecipeById(@PathVariable("id") Long id, final Model model) {
		log.info("Inside RecipeController. Recipe ID: " + id );
		Recipe recipe = recipeService.findById(id);
		model.addAttribute("recipe", recipe);
		return "recipe/show";
	}
	
	@RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }
	
	@RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }


    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }
    
    
}
