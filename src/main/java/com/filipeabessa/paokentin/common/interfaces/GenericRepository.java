package com.filipeabessa.paokentin.common.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, K> {
    T create(T entity) throws SQLException;
    T update(T entity);
    void deleteById(K id);
    List<T> findAll();
    Optional<T> findById(K id);
}
