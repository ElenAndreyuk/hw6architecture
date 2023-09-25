package ru.geekbrains.lesson6.notes.core.application;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;
    ArrayList<Note> notes ;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
        this.notes = (ArrayList<Note>) dbContext.getAll();
    }

    @Override
    public boolean add(Note item) {
        notes.add(item);
        return dbContext.saveChanges(notes);
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(new Date());
        return dbContext.saveChanges(notes);
    }

    /**
     * Откорректировала методы удаления заметок
     */
    @Override
    public boolean remove(Note item){
        if(notes.contains(item)) {
            notes.remove(item);
            return dbContext.saveChanges(notes);
        }else {
            return false;
        }
    }

    @Override
    public boolean remove(Integer id) throws RuntimeException{
        Note note = searchForId(id, notes);
        if(notes.remove(note)){
        return dbContext.saveChanges(notes);
        }else return false;

    }

    public  Note searchForId(Integer id,  Collection<Note> notes){
        for (Note note: notes) {
            if(note.getId() == id){
                Note item = note;
                return item;
            }else {
                throw new RuntimeException("Заметка не найдена");
            }
        }
        return null;
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return notes;
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }
}
