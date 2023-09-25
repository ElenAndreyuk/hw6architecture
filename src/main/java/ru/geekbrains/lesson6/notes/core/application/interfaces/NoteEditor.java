package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    boolean remove(Integer id);

    void printAll();
}
