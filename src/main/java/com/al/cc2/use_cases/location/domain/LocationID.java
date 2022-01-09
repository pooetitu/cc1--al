package com.al.cc2.use_cases.location.domain;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class LocationID implements ObjectID {
    private final String value;

    private LocationID(String value) {
        this.value = value;
    }

    public static LocationID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static LocationID of(String value) {
        return new LocationID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationID that = (LocationID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
