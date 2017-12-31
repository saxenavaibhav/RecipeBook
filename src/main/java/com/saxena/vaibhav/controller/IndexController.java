package com.saxena.vaibhav.controller;

/**
 * Created by Vaibhav Saxena.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saxena.vaibhav.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.info("IndexController: getIndexPage() method.");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
