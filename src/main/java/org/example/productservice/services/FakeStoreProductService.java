//package org.example.productservice.services;
//
//import org.example.productservice.dtos.FakeStoreProductDto;
//import org.example.productservice.dtos.FakeStoreProductDtoCollection;
//import org.example.productservice.exceptions.ProductNotFoundException;
//import org.example.productservice.models.Category;
//import org.example.productservice.models.Product;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FakeStoreProductService implements ProductService{
//
//    RestTemplate restTemplate;
//
//    public FakeStoreProductService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public Product getProductById(Long id) throws ProductNotFoundException {
//        FakeStoreProductDto fakeStoreProductDto = restTemplate
//                .getForObject(
//                        "https://fakestoreapi.com/products/" + id,
//                        FakeStoreProductDto.class
//                );
//        if (fakeStoreProductDto == null){
//            throw new ProductNotFoundException(351L, "Product not found for id " + id);
//        }
//        return ConvertFakeStoreDtoToProduct(fakeStoreProductDto);
//    }
//
//    @Override
//    public List<Product> getProducts() {
//        List<Product> productList = new ArrayList<>();
//
//        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDto[].class
//        );
//
//        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
//            productList.add(ConvertFakeStoreDtoToProduct(fakeStoreProductDto));
//        }
//
//        return productList;
//    }
//
//    @Override
//    public Product updateProduct(Long id, Product product) {
//        restTemplate.put("https://fakestoreapi.com/products/" + id, product);
//
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
//        Product product1 = restTemplate.execute("https://fakestoreapi.com/products/" + id,
//                HttpMethod.PUT,
//                requestCallback,
//                null);
//
//        System.out.println("Serv");
//        System.out.println(product1);
//        return product1;
//    }
//
//    @Override
//    public Product createProduct(Product product) {
//        return null;
//    }
//
//
//    private Product ConvertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
//        if (fakeStoreProductDto == null){
//            return null;
//        }
//
//        Product product = new Product();
//
//        Category category = new Category();
//
//        category.setId(null);
//        category.setTitle(fakeStoreProductDto.getCategory());
//
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setCategory(category);
//
//        return product;
//    }
//}
