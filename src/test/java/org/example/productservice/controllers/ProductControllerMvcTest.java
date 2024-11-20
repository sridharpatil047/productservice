package org.example.productservice.controllers;

import org.example.productservice.exceptions.ProductNotFoundException;
import org.example.productservice.models.Product;
import org.example.productservice.services.CategoryService;
import org.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;
    @MockBean
    CategoryService categoryService;

    @Test
    void shouldReturnUserWhenProductIdExists() throws Exception {

        Product mockedProduct = new Product();
        mockedProduct.setId(1L);
        mockedProduct.setTitle("Test 1");
        mockedProduct.setPrice(123.4);
        when(productService.getProductById(1L))
                .thenReturn(mockedProduct);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test 1"));

    }

    @Test
    void shouldReturnNotFoundWhenProductIdNotExists() throws Exception {

        when(productService.getProductById(1L))
                .thenThrow(ProductNotFoundException.class);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isNotFound());
    }
}
