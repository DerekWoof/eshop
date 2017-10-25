package com.shop.model;

import java.math.BigDecimal;

public class Product {

    private static int ID_COUNTER = 0;

    private int id;
    private String description;
    private Money money;
    private String fullDescription;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(BigDecimal value) {
        money.setValue(value);
    }

    public void setCurrency(String currency) {
        money.setCurrency(currency);
    }


    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Product(String description, BigDecimal value, String currency, String fullDescription) {
        this.description = description;
        this.money = new Money(value, currency);
        this.fullDescription = fullDescription;
        id = ID_COUNTER++;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return money.getValue();
    }

    public String getCurrency() {
        return money.getCurrency();
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
