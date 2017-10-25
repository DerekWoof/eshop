package com.shop.service;

import com.shop.model.ShoppingCart;

import javax.servlet.http.HttpSession;

/**
 * Created by Rafal on 2017-10-09.
 */
public class SessionShoppingCartHandler {

    public static ShoppingCart retrieveShoppingCart(HttpSession session) {
        if (session.getAttribute("shoppingCart") == null) {
            session.setAttribute("shoppingCart", new ShoppingCart());
        }
        return (ShoppingCart) session.getAttribute("shoppingCart");
    }
}