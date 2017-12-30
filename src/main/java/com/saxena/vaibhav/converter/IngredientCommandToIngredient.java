package com.saxena.vaibhav.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.saxena.vaibhav.command.IngredientCommand;
import com.saxena.vaibhav.domain.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
	
	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Override
	@Nullable
	public Ingredient convert(IngredientCommand source) {
		if (source == null) {
			return null;
		}
		final Ingredient ingredient = new Ingredient();
		ingredient.setAmount(source.getAmount());
		ingredient.setDescription(source.getDescription());
		ingredient.setId(source.getId());
		ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
		return ingredient;
	}

}
