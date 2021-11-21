package com.al.domain.validators;

import com.al.domain.models.MembershipApplication;

public interface Predicate<T> {
    boolean validate(T entity);
}
