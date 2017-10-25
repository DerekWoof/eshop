package com.shop.model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Rafal on 2017-10-09.
 */
public class ShoppingCart {

    private Set<ProductItem> productItems;

    public ShoppingCart() {
        productItems = new HashSet<>();
    }

    public void add(Product product) {
        Optional<ProductItem> optionalProductItem = productItems.stream()
                    .filter(p->p.getProduct().getId() == product.getId())
                    .findFirst();
        if(optionalProductItem.isPresent())
            optionalProductItem.get().incrementQuantity();
        else {
            ProductItem productItem = new ProductItem(product);
            productItems.add(productItem);
        }
    }

    public void remove(Product product) {
        Optional<ProductItem> optionalProductItem = productItems.stream()
                .filter(p->p.getProduct().getId() == product.getId())
                .findFirst();
        if(optionalProductItem.isPresent()) {
            ProductItem productItem = optionalProductItem.get();
            productItems.remove(productItem);
        }
    }

    public int getShoppingCartItemSize() {
        return productItems.size();
    }

    public int getProductItemAmount(int productId) {
        Optional<Integer> amount = productItems.stream()
                                               .filter(p->p.getProduct().getId() == productId)
                                               .map(p->p.getQuantity())
                                               .findFirst();
        return amount.isPresent() ? amount.get() : 0;
    }

    Set<ProductItem> productItemList() {
        return productItems;
    }



}