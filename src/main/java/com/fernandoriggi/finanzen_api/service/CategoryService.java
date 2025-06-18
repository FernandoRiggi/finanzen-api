package com.fernandoriggi.finanzen_api.service;

import com.fernandoriggi.finanzen_api.dto.category.CategoryResponseDTO;
import com.fernandoriggi.finanzen_api.model.Category;
import com.fernandoriggi.finanzen_api.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    @Transactional
    public Category updateCategory(Long id, Category categoryDetails){
        Category existingCategory = categoryRepository.findById(id)
                                    .orElseThrow(()-> new RuntimeException("Category not found: " + id));
        existingCategory.setName(categoryDetails.getName());
        existingCategory.setDescription(categoryDetails.getDescription());

        return categoryRepository.save(existingCategory);
    }

    @Transactional
    public void deleteCategory(Long id){
        if(!categoryRepository.existsById(id)) throw new NoSuchElementException("Entity not found: " + id);

        categoryRepository.deleteById(id);
    }
}
