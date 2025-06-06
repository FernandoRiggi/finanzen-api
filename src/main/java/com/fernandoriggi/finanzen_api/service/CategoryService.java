package com.fernandoriggi.finanzen_api.service;

import com.fernandoriggi.finanzen_api.model.Category;
import com.fernandoriggi.finanzen_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
}
