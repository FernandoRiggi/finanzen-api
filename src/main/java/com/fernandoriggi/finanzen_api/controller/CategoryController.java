package com.fernandoriggi.finanzen_api.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    //CREATE CATEGORY
    @PostMapping("/create")
    public String createCategory(){
        return "Category created";
        }
    //READ ALL CATEGORY
    @GetMapping("/all")
    public String showCategories(){
        return "Categories";
    }
    //READ ONE CATEGORY
    @GetMapping("/{id}")
    public String showCategoryByID(Long id){
        return "Category";
    }
    //UPDATE CATEGORY
    @PutMapping("/{id}")
    public String updateCategory(Long id){
        return "Updated Category";
    }
    //DELETE CATEGORY
    @DeleteMapping("/{id}")
    public String deleteCategory(Long id){
        return "Deleted Category";
    }
}
