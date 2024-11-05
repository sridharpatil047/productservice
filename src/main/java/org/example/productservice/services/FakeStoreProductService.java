package org.example.productservice.services;

import org.example.productservice.dtos.FakeStoreProductDto;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate
                .getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class
                );
        return ConvertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    private Product ConvertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        if (fakeStoreProductDto == null){
            return null;
        }

        Product product = new Product();

        Category category = new Category();

        category.setId(null);
        category.setTitle(fakeStoreProductDto.getCategory());

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;
    }
}
