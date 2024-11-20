package org.example.productservice.examples.fetchtypes.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostResponseDto {
    Long id;
    String title;
    Long userId;
}
