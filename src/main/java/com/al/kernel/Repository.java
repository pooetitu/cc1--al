package com.al.kernel;

import java.util.List;
import java.util.NoSuchElementException;

public interface Repository<ID extends ObjectID, OBJECT extends Entity<ID>> {
    ID nextId();

    List<OBJECT> findAll();

    OBJECT byId(ID id) throws NoSuchElementException;

    void update(ID id, OBJECT entity);

    void add(OBJECT entity);

    void delete(ID id);
}
