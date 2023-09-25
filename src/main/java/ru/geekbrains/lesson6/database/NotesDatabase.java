package ru.geekbrains.lesson6.database;

import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.Database;

import java.util.ArrayList;

public class NotesDatabase implements Database {

    private NotesTable notesTable;

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }

    public boolean saveChanges(ArrayList<Note> notes){
        notesTable.getRecords(notes);
        return false;
    }
}
