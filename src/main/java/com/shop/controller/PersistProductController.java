package com.shop.controller;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static com.shop.repository.impl.ProductRepositoryImpl.*;

@WebServlet(name = "PersistProductController", value = "/persistProduct")
public class PersistProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("addProductForm.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String description = httpServletRequest.getParameter("description");
        BigDecimal value = BigDecimal.valueOf(Long.parseLong(httpServletRequest.getParameter("value")));
        String currency = httpServletRequest.getParameter("currency");
        String fullDescription = httpServletRequest.getParameter("fullDescription");
        Product product = new Product(description, value, currency, fullDescription);
        ProductService productService = ProductService.productService(aProductRepository());
        productService.getAllProductsForCustomer().add(product);
        httpServletResponse.sendRedirect("/");
    }
}
