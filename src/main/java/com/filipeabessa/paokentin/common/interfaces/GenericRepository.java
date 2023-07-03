package com.filipeabessa.paokentin.common.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<Class, Key> {
    Class create(Class entity) throws SQLException;
    Class update(Class entity);
    void deleteById(Key id);
    List<Class> findAll();
    Optional<Class> findById(Key id);
}
