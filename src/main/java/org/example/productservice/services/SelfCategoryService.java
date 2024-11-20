package org.example.productservice.services;

import org.example.productservice.models.Category;
import org.example.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class SelfCategoryService implements CategoryService{
    CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
