package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreCategoryResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis.FakeStoreRetrofitApis;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGatewayImpl implements CategoryGateway{
    public final FakeStoreRetrofitApis fakeStoreRetrofitApis;

    public FakeStoreCategoryGatewayImpl(FakeStoreRetrofitApis fakeStoreRetrofitApis){
        this.fakeStoreRetrofitApis = fakeStoreRetrofitApis;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDto response = this.fakeStoreRetrofitApis.getAllCategories()
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
