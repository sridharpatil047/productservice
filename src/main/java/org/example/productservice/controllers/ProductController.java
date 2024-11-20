package org.example.productservice.controllers;

import org.example.productservice.dtos.ProductNotFoundExceptionDto;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.example.productservice.models.Product;
import org.example.productservice.services.CategoryService;
import org.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println();
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        Product product1 = productService.updateProduct(id, product);
        System.out.println(product1);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.out.println();

        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
}







