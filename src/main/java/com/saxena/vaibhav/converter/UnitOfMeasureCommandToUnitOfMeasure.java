package com.saxena.vaibhav.converter;

/**
 * Created by Vaibhav Saxena.
 */

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.saxena.vaibhav.command.UnitOfMeasureCommand;
import com.saxena.vaibhav.domain.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand source) {
		if (source == null) {
			return null;
		}

		final UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(source.getId());
		uom.setDescription(source.getDescription());
		return uom;
	}
}