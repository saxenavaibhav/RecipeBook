package com.saxena.vaibhav.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;

	@Before
	public void setup() {
		category =  new Category();
	}
	
	@Test
	public void testGetId() {
		
		long id = 4L; 
		category.setId(id);
		assertEquals(id, category.getId().longValue());
	}

//	@Test
//	public void testGetDescription() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetRecipes() {
//		fail("Not yet implemented");
//	}

}
