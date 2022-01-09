package com.al.cc2.use_cases.payment.domain;

import com.al.cc2.kernel.ObjectID;

import java.util.Objects;
import java.util.UUID;

public class PaymentID implements ObjectID {
    private final String value;

    private PaymentID(String value) {
        this.value = value;
    }

    public static PaymentID fromUUID(UUID uuid) {
        return of(uuid.toString());
    }

    public static PaymentID of(String value) {
        return new PaymentID(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentID that = (PaymentID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
