package org.example.productservice.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    private Long id;
    public ProductNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
