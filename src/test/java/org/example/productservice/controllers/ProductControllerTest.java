package org.example.productservice.controllers;

import org.example.productservice.exceptions.ProductNotFoundException;
import org.example.productservice.models.Product;
import org.example.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @MockBean(name = "selfProductService")
    ProductService productService;

    @Autowired
    ProductController productController;

    @Test
    // when---Then---
    void whenGetProductByIdThenReturnCorrectTitle() throws ProductNotFoundException {

        // Arrange
        Long productId = 1L;

        // Act

        // Mocked Product 1
        Product mockedProduct1 = new Product();
        mockedProduct1.setId(1L);
        mockedProduct1.setTitle("Test1");
        mockedProduct1.setPrice(123.4);
        when(productService.getProductById(1L))
                .thenReturn(mockedProduct1);


        // Mocked Product 2
        Product mockedProduct2 = new Product();
        mockedProduct2.setId(2L);
        mockedProduct2.setTitle("Test2");
        mockedProduct2.setPrice(123.4);
        when(productService.getProductById(2L))
                .thenReturn(mockedProduct2);


        // Mocked Product 3
        when(productService.getProductById(3L))
                .thenReturn(null);

        Product actualProduct = productController.getProductById(productId).getBody();

        // Assert
        Assertions.assertNotNull(actualProduct,
                "Product is NULL");

        Assertions.assertEquals("Test1",
                actualProduct.getTitle(),
                "Title is not correct");
    }

}
