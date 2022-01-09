package com.al.cc2.use_cases.payment.infrastructure;

import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentID;
import com.al.cc2.use_cases.payment.domain.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class InMemoryPaymentRepository implements PaymentRepository {
    private final HashMap<PaymentID, Payment> payments;

    public InMemoryPaymentRepository() {
        this.payments = new HashMap<>();
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }

    @Override
    public Payment byId(PaymentID paymentID) {
        Payment payment = payments.get(paymentID);
        if (payment == null) {
            throw new NoSuchElementException();
        }
        return payment;
    }

    @Override
    public void update(PaymentID paymentID, Payment payment) {
        payments.replace(paymentID, payment);
    }

    @Override
    public void add(Payment payment) {
        payments.put(payment.id(), payment);
    }

    @Override
    public void delete(PaymentID paymentID) {
        payments.remove(paymentID);
    }
}
