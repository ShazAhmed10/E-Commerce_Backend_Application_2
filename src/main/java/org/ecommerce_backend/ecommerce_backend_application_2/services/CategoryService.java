package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryProductDto;

import java.util.List;

public interface CategoryService {

    public List<CategoryDto> getAllCategories() throws Exception;

    public CategoryDto getCategoryByName(String categoryName) throws Exception;

    public CategoryDto createCategory(CategoryDto categoryDto) throws Exception;

    public CategoryProductDto getAllProductsWithCategory(String categoryName) throws Exception;
}
