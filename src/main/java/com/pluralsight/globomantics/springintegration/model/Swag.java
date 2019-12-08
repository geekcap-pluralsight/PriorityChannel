package com.pluralsight.globomantics.springintegration.model;

public class Swag {
    private String type;
    private long amount;

    public Swag(String type, long amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Swag{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
