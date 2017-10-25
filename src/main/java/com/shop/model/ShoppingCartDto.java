package com.shop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2017-10-09.
 */
public class ShoppingCartDto {

    List<ProductDto> productDTOList;

    public ShoppingCartDto(ShoppingCart shoppingCart) {
        productDTOList = new ArrayList<>();
        shoppingCart.productItemList().forEach(p->{
           ProductDto productDto = new ProductDto(p);
            productDTOList.add(productDto);
        });
    }
}
