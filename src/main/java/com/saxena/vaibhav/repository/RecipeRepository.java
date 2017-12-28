package com.saxena.vaibhav.repository;

import org.springframework.data.repository.CrudRepository;

import com.saxena.vaibhav.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
