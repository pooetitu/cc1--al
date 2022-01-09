package com.al.cc2.domain.ids;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class PeriodID implements ObjectID {
    private final String value;

    private PeriodID(String value) {
        this.value = value;
    }

    public static PeriodID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static PeriodID of(String value) {
        return new PeriodID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodID that = (PeriodID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
