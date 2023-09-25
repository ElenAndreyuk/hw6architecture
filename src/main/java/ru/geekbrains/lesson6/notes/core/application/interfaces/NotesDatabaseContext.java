package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.ArrayList;
import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();



    boolean saveChanges(ArrayList<Note> notes);
}
