package com.saxena.vaibhav.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.saxena.vaibhav.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String description);
}
