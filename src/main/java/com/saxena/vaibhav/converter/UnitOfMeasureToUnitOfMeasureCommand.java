package com.saxena.vaibhav.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.saxena.vaibhav.command.UnitOfMeasureCommand;
import com.saxena.vaibhav.domain.UnitOfMeasure;

import lombok.Synchronized;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure source) {
		if (source == null) {
			return null;
		}
		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(source.getId());
		uomCommand.setDescription(source.getDescription());
		return uomCommand;
	}

}
