package com.al.cc2.use_cases.subscription.domain;

public enum SubscriptionType {
    CLASSIC(7.99f), PREMIUM(12.99f);
    private final float price;

    SubscriptionType(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
