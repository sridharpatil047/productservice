package org.example.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductServiceConfig {

    @Bean
    public RestTemplate restTemplate(){
        System.out.println("***** Createing Been *****");
        return new RestTemplate();
    }
}
