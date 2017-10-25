package com.shop.service;

import com.shop.model.Product;
import com.shop.model.ShoppingCart;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.ProductRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private static ProductService productService;

    private ProductRepository repository;

    public static ProductService productService(ProductRepository productRepository) {
        if (productService != null)
            return productService;
        productService = new ProductService(productRepository);
        return productService;
    }

    private ProductService(ProductRepository productRepository) {
        repository = productRepository;
    }

    public List<Product> getAllProductsForCustomer() {
        return repository.getAllProducts();
    }

    public List<Product> getProductBySearchCriteria(final String searchCriteria) {
        List<Product> products = repository.getAllProducts();
        return products.stream().filter(p -> p.getDescription().toLowerCase().contains(searchCriteria.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addProductToShoppingCart(ShoppingCart shoppingCart, int productId) {
        Product product = repository.getProductById(productId);
        shoppingCart.add(product);
    }


    public void editProduct(int productId, String description, String fullDescription, String currency, BigDecimal value) {
        Product product = getProductById(productId);
        product.setDescription(description);
        product.setFullDescription(fullDescription);
        product.setCurrency(currency);
        product.setValue(value);
        repository.updateProduct(product);
    }

    public Product getProductById(final int id) {
        return repository.getAllProducts().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
