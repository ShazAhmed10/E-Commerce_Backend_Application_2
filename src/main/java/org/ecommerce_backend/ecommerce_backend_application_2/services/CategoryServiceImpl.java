package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;
import org.ecommerce_backend.ecommerce_backend_application_2.mappers.CategoryMapper;
import org.ecommerce_backend.ecommerce_backend_application_2.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws Exception {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper :: toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) throws Exception {
        return categoryRepository.findByName(categoryName)
                .map(CategoryMapper :: toDto)
                .orElseThrow(() -> new Exception("There is no valid category for the given categoryName"));
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) throws Exception {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryDto.getName());
        if(categoryOptional.isPresent()){
            throw new Exception("The category name provided is already present");
        }

        Category savedCategory = categoryRepository.save(CategoryMapper.toEntity(categoryDto));
        return CategoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryProductDto getAllProductsWithCategory(String categoryName) throws Exception {
        return categoryRepository.findByName(categoryName)
                .map(CategoryMapper :: toCategoryProductDto)
                .orElseThrow(() -> new Exception("There is no valid category for the given categoryName"));
    }
}
