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

import static java.lang.Integer.*;

/**
 * Created by Rafal on 2017-10-06.
 */
@WebServlet(name = "EditProductController", value = "/editProduct")
public class EditProductController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int productId = parseInt(httpServletRequest.getParameter("id"));
        Product product = ProductService.productService(ProductRepositoryImpl.aProductRepository()).getProductById(productId);
        httpServletRequest.setAttribute("product", product);
        httpServletRequest.getRequestDispatcher("editProduct.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int productId = parseInt(httpServletRequest.getParameter("idDis"));
        String description = httpServletRequest.getParameter("description");
        String fullDescription = httpServletRequest.getParameter("fullDescription");
        BigDecimal value = new BigDecimal(httpServletRequest.getParameter("value"));
        String currency = httpServletRequest.getParameter("currency");
        ProductService.productService(ProductRepositoryImpl.aProductRepository()).editProduct(productId,description,fullDescription,currency,value);
        httpServletResponse.sendRedirect("/");

    }
}
