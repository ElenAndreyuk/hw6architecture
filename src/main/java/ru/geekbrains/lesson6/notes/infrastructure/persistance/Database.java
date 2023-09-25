package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.ArrayList;

public interface Database {
    boolean saveChanges(ArrayList<Note> notes);
}
