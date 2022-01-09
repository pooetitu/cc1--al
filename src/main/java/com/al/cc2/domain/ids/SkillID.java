package com.al.cc2.domain.ids;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class SkillID implements ObjectID {
    private final String value;

    private SkillID(String value) {
        this.value = value;
    }

    public static SkillID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static SkillID of(String value) {
        return new SkillID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillID that = (SkillID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
