package org.example.productservice.services;

import org.example.productservice.exceptions.ProductNotFoundException;
import org.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestingProductService implements ProductService{
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
