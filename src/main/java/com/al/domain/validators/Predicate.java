package com.al.domain.validators;

public interface Predicate<T> {
    boolean validate(T entity);
}
