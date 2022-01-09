package com.al.cc2.kernel;

import java.util.List;
import java.util.NoSuchElementException;

public interface Repository<I extends ObjectID, O extends Entity<I>> {
    I nextId();

    List<O> findAll();

    O byId(I i) throws NoSuchElementException;

    void update(I i, O entity);

    void add(O entity);

    void delete(I i);
}
