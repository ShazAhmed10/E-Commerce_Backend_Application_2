package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RestTemplateFakeStoreCategoryResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.mappers.RestTemplateGetAllCategoriesMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
public class RestTemplateFakeStoreCategoryGateway implements CategoryGateway{
    private final RestTemplate restTemplate;
    private final String fakeStoreBaseUrl;

    public RestTemplateFakeStoreCategoryGateway
            (
                    RestTemplateBuilder builder,
                    @Value("${fakeStore.baseUrl}") String fakeStoreBaseUrl
            )
    {
        this.restTemplate = builder.build();
        this.fakeStoreBaseUrl = fakeStoreBaseUrl;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        RestTemplateFakeStoreCategoryResponseDto response = restTemplate
                .getForObject(
                        this.fakeStoreBaseUrl + "/products/category",
                        RestTemplateFakeStoreCategoryResponseDto.class
                );

        if(response.getCategories() == null){
            throw new IOException("Failed to fetch all categories");
        }

        return RestTemplateGetAllCategoriesMapper.toCategoryDtoList(response);
    }
}
