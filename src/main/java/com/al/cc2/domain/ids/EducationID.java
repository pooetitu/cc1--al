package com.al.cc2.domain.ids;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class EducationID implements ObjectID {
    private final String value;

    private EducationID(String value) {
        this.value = value;
    }

    public static EducationID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static EducationID of(String value) {
        return new EducationID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationID that = (EducationID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
