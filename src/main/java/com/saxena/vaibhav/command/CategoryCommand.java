package com.saxena.vaibhav.command;

/**
 * Created by Vaibhav Saxena.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
	
	private Long id;
	private String description;

}
