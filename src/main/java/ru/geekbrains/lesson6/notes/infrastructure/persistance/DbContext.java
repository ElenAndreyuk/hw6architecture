package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.ArrayList;
import java.util.Collection;

public abstract class DbContext {

    protected Database database;

    public DbContext(Database database) {
        this.database = database;
    }

    protected abstract void onModelCreating(ModelBuilder builder);


    public abstract boolean saveChanges(Collection<T> items);
}

class ModelBuilder {

    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        //TODO: добавление конфигурации маппинга объекта некоторого типа к структуре таблицы БД
        return this;
    }

}
