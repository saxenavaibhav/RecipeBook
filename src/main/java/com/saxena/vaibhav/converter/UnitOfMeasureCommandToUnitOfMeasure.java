package com.saxena.vaibhav.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.saxena.vaibhav.command.UnitOfMeasureCommand;
import com.saxena.vaibhav.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand source) {
		if (source == null) {
			return null;
		}
		
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(source.getId());
		uom.setDescription(source.getDescription());
		return uom;
	}

}
