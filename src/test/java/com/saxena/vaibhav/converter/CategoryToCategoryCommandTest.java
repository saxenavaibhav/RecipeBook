package com.saxena.vaibhav.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.saxena.vaibhav.command.CategoryCommand;
import com.saxena.vaibhav.domain.Category;

public class CategoryToCategoryCommandTest {
	
	public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "descript";
	CategoryToCategoryCommand converter;

	@Before
	public void setup() {
		converter = new CategoryToCategoryCommand();
	}
	
	@Test
	public void testNullObject() {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() {
		assertNotNull(converter.convert(new Category()));
	}
	
	@Test
	public void convert() {
		//Given
		Category cat = new Category();
		cat.setId(ID_VALUE);
		cat.setDescription(DESCRIPTION);
		
		//When
		CategoryCommand categoryCommand = converter.convert(cat);
		
		//then
		assertEquals(ID_VALUE, categoryCommand.getId());
		assertEquals(DESCRIPTION, categoryCommand.getDescription());
	}
}
