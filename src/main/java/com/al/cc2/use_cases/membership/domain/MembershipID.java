package com.al.cc2.use_cases.membership.domain;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class MembershipID implements ObjectID {
    private final String value;

    private MembershipID(String value) {
        this.value = value;
    }

    public static MembershipID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static MembershipID of(String value) {
        return new MembershipID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipID that = (MembershipID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
