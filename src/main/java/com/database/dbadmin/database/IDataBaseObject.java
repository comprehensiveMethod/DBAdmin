package com.database.dbadmin.database;

public interface IDataBaseObject<T> {
    void save(T t);
    void delete(T t);
    void update(T t);
    T get(Long id);
}
