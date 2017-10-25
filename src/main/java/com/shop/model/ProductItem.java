package com.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Created by Rafal on 2017-10-09.
 */
@Getter
class ProductItem {

    private Product product;
    private Integer quantity;

    public ProductItem(Product product) {
        this.product = product;
        quantity = new Integer(1);
    }

    public BigDecimal value() {
        BigDecimal bigDecimalQuantity = BigDecimal.valueOf(quantity);
        return  product.getValue().multiply(bigDecimalQuantity);
    }

    public void incrementQuantity() {
        quantity++;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
