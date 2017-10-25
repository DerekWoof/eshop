package com.shop.controller;


import com.shop.model.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.shop.repository.impl.ProductRepositoryImpl.*;

@WebServlet(name = "HomeController", value = "/")
public class HomeController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ProductService productService = ProductService.productService(aProductRepository());
        List<Product> productList = productService.getAllProductsForCustomer();
        httpServletRequest.setAttribute("productList", productList);

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
