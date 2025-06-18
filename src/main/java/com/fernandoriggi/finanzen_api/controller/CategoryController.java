package com.fernandoriggi.finanzen_api.controller;

import com.fernandoriggi.finanzen_api.controller.mapper.CategoryMapper;
import com.fernandoriggi.finanzen_api.dto.category.CategoryRequestDTO;
import com.fernandoriggi.finanzen_api.dto.category.CategoryResponseDTO;
import com.fernandoriggi.finanzen_api.model.Category;
import com.fernandoriggi.finanzen_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //CREATE CATEGORY
    @PostMapping()
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody @Valid CategoryRequestDTO requestDTO){
        Category categoryToSave = CategoryMapper.toEntity(requestDTO);
        Category savedCategory = categoryService.createCategory(categoryToSave);
        CategoryResponseDTO responseDTO = CategoryMapper.toResponseDTO(savedCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }

        //READ ALL CATEGORY
    @GetMapping()
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        List<CategoryResponseDTO> responseDTOS = categories.stream()
                                                            .map(CategoryMapper::toResponseDTO)
                                                            .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    //READ ONE CATEGORY
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findCategoryById(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));
        CategoryResponseDTO responseDTO = CategoryMapper.toResponseDTO(category);
        return ResponseEntity.ok(responseDTO);
    }

    //UPDATE CATEGORY
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid CategoryRequestDTO categoryRequestDTO){
            Category categoryDetails = CategoryMapper.toEntity(categoryRequestDTO);
            Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
            CategoryResponseDTO responseDTO = CategoryMapper.toResponseDTO(updatedCategory);
            return ResponseEntity.ok(responseDTO);
    }

    //DELETE CATEGORY
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
