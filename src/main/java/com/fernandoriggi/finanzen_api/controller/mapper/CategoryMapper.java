package com.fernandoriggi.finanzen_api.controller.mapper;

import com.fernandoriggi.finanzen_api.dto.category.CategoryRequestDTO;
import com.fernandoriggi.finanzen_api.dto.category.CategoryResponseDTO;
import com.fernandoriggi.finanzen_api.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO dto){
        if(dto==null) return null;

        Category category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }

    public static CategoryResponseDTO toResponseDTO(Category category){
        if(category==null) return null;

        return new CategoryResponseDTO(category.getId(), category.getName(), category.getDescription());
    }

    public static List<CategoryResponseDTO> toResponseDTOList(List<Category> categories){
        if(categories==null) return null;

        return categories.stream()
                .map(CategoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
