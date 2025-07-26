package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreCategoryResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis.FakeStoreRetrofitCategoryApis;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGatewayRetrofit implements CategoryGateway{
    public final FakeStoreRetrofitCategoryApis fakeStoreRetrofitCategoryApis;

    public FakeStoreCategoryGatewayRetrofit(FakeStoreRetrofitCategoryApis fakeStoreRetrofitCategoryApis){
        this.fakeStoreRetrofitCategoryApis = fakeStoreRetrofitCategoryApis;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDto response = this.fakeStoreRetrofitCategoryApis.getAllCategories()
                .execute()
                .body();

        if(response == null){
            throw new IOException("Failed to fetch all categories");
        }

        return response
                .getCategories()
                .stream()
                .map(category -> CategoryDto
                        .builder()
                        .name(category)
                        .build())
                .toList();
    }
}
