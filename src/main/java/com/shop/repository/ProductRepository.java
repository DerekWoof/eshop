package com.shop.repository;

import com.shop.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    void updateProduct(Product product);

    Product getProductById(int productId);
}
