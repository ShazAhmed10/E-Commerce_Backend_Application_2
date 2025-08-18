package org.ecommerce_backend.ecommerce_backend_application_2.controllers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String categoryName)  throws Exception {
        if(categoryName != null && !categoryName.isBlank()){
            CategoryDto response = categoryService.getCategoryByName(categoryName);
            return ResponseEntity.ok(response);
        }
        else {
            List<CategoryDto> response = this.categoryService.getAllCategories();
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) throws Exception{
        CategoryDto response = categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<CategoryProductDto> getAllProductsWithCategory
            (@RequestParam(required = true) String categoryName) throws Exception{
        CategoryProductDto response = categoryService.getAllProductsWithCategory(categoryName);
        return ResponseEntity.ok(response);
    }
}
