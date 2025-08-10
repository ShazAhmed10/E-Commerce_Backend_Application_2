package org.ecommerce_backend.ecommerce_backend_application_2.mappers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RetrofitFakeStoreCategoryResponseDto;

import java.util.List;

public class RetrofitGetAllCategoriesMapper {

    public static List<CategoryDto> toCategoryDtoList(RetrofitFakeStoreCategoryResponseDto responseDto){
        return responseDto.getCategories()
                .stream()
                .map(category -> CategoryDto
                        .builder()
                        .name(category)
                        .build())
                .toList();
    }
}
