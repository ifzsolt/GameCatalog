package hu.nye.progkor.gamecatalog.data.repository;

import java.util.List;

/**
 *TODO.
 */
public interface Repository <T, ID>{
    T save(T item);
    T getById(ID id);
    List<T> getAll();
    T update(T item);
    void deleteByID(ID id);
}
