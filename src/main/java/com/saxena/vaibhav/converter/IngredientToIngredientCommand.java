package com.saxena.vaibhav.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.saxena.vaibhav.command.IngredientCommand;
import com.saxena.vaibhav.domain.Ingredient;

import lombok.Synchronized;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

	private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;
	
	public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient source) {

		if (source == null) {
			return null;
		}
		
		IngredientCommand ic = new IngredientCommand();
		ic.setId(source.getId());
		ic.setAmount(source.getAmount());
		ic.setDescription(source.getDescription());
		ic.setUom(uomConverter.convert(source.getUom()));
		return ic;
	}

}
