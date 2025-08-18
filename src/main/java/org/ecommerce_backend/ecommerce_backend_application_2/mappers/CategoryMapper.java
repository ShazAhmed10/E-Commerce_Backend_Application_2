package org.ecommerce_backend.ecommerce_backend_application_2.mappers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        return Category.builder()
                .name(categoryDto.getName())
                .build();
    }

    public static CategoryProductDto toCategoryProductDto(Category category){
        return CategoryProductDto.builder()
                .id(category.getId())
                .name(category.getName())
                .productDtoList(category.getProductList().stream()
                        .map(ProductMapper :: toDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
