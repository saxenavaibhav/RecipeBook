package com.saxena.vaibhav.repository;

/**
 * Created by Vaibhav Saxena.
 */

import org.springframework.data.repository.CrudRepository;

import com.saxena.vaibhav.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
