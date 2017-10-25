package com.shop.model;

import java.math.BigDecimal;

/**
 * Created by Rafal on 2017-10-09.
 */
public class ProductDto {

    private int id;
    private String description;
    private BigDecimal value;
    private String currency;
    private int quantity;

    public ProductDto(ProductItem productItem) {
        this.id = productItem.getProduct().getId();
        this.description = productItem.getProduct().getDescription();
        this.value = productItem.getProduct().getValue();
        this.currency = productItem.getProduct().getCurrency();
        this.quantity = productItem.getQuantity();
    }



}
