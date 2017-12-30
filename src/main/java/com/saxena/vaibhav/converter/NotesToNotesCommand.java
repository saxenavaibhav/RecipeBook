package com.saxena.vaibhav.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.saxena.vaibhav.command.NotesCommand;
import com.saxena.vaibhav.domain.Notes;

import lombok.Synchronized;

public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
