package com.saxena.vaibhav.service;

/**
 * Created by Vaibhav Saxena.
 */

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.saxena.vaibhav.command.UnitOfMeasureCommand;
import com.saxena.vaibhav.converter.UnitOfMeasureToUnitOfMeasureCommand;
import com.saxena.vaibhav.repository.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureService {

	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	public UnitOfMeasureService(UnitOfMeasureRepository unitOfMeasureRepository,
			UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	public Set<UnitOfMeasureCommand> listAllUoms() {

		return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
				.map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());
	}
}
