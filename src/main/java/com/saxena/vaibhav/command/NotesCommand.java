package com.saxena.vaibhav.command;

/**
 * Created by Vaibhav Saxena.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

	private Long id;
	private String recipeNotes;
	
}
