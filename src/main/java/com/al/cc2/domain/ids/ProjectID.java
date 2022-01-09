package com.al.cc2.domain.ids;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class ProjectID implements ObjectID {
    private final String value;

    private ProjectID(String value) {
        this.value = value;
    }

    public static ProjectID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static ProjectID of(String value) {
        return new ProjectID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectID that = (ProjectID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
