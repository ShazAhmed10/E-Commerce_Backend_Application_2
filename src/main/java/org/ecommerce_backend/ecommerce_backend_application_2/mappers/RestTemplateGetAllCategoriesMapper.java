package org.ecommerce_backend.ecommerce_backend_application_2.mappers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RestTemplateFakeStoreCategoryResponseDto;

import java.util.List;

public class RestTemplateGetAllCategoriesMapper {

    public static List<CategoryDto> toCategoryDtoList(RestTemplateFakeStoreCategoryResponseDto responseDto){
        return responseDto.getCategories()
                .stream()
                .map(category -> CategoryDto
                        .builder()
                        .name(category)
                        .build())
                .toList();
    }
}
