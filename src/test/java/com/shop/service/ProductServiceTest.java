package com.shop.service;

import com.shop.model.Product;
import com.shop.model.ShoppingCart;
import com.shop.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.math.BigDecimal;

/**
 * Created by Rafal on 2017-10-09.
 */

public class ProductServiceTest {

    public static final String SAMPLE = "SAMPLE";
    public static final BigDecimal VALUE = new BigDecimal(10);
    public static final String CURRENCY = "PLN";
    public static final String FULL_DESCRIPTION = "FULL DESC";

    private ProductRepository productRepository;


    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp(){
        productRepository = Mockito.mock(ProductRepository.class);
        productService = ProductService.productService(productRepository);
    }


    @Test
    public void shouldNewShoppingCartContainOneProductIfUserAddProductToShoppingCart() {
        //given
        int productId = 0;
        ShoppingCart shoppingCart = new ShoppingCart();
        Mockito.when(productRepository.getProductById(productId)).thenReturn(aSimpleProduct());
        //when
        productService.addProductToShoppingCart(shoppingCart,0);
        //then
        Assert.assertEquals("The size of the shopping cart should be 1", 1,shoppingCart.getShoppingCartItemSize());
    }

    @Test
    public void shouldShoppingCartContainOneProductWithAmountTwoWhenUserAddTheSameProductTwoTimes() {
        //given
        int productId = 0;
        ShoppingCart shoppingCart = new ShoppingCart();
        Mockito.when(productRepository.getProductById(productId)).thenReturn(aSimpleProduct());
        //when
        productService.addProductToShoppingCart(shoppingCart,0);
        productService.addProductToShoppingCart(shoppingCart,0);
        //then
        Assert.assertEquals("The size of the shopping cart should be 1", 1,shoppingCart.getShoppingCartItemSize());
        Assert.assertEquals("The amount of the product should be two",2, shoppingCart.getProductItemAmount(productId));
    }


    private Product aSimpleProduct(){
        return new Product(SAMPLE, VALUE, CURRENCY, FULL_DESCRIPTION);
    }



}