package org.example.productservice.dtos;

import lombok.Getter;

@Getter
public class ProductNotFoundExceptionDto {
    private Long errorCode;
    private String message;

    public ProductNotFoundExceptionDto(Long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
