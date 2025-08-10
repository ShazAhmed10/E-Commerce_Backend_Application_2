package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RetrofitFakeStoreCategoryResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis.FakeStoreRetrofitCategoryApis;
import org.ecommerce_backend.ecommerce_backend_application_2.mappers.RetrofitGetAllCategoriesMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class RetrofitFakeStoreCategoryGateway implements CategoryGateway{
    public final FakeStoreRetrofitCategoryApis fakeStoreRetrofitCategoryApis;

    public RetrofitFakeStoreCategoryGateway(FakeStoreRetrofitCategoryApis fakeStoreRetrofitCategoryApis){
        this.fakeStoreRetrofitCategoryApis = fakeStoreRetrofitCategoryApis;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        RetrofitFakeStoreCategoryResponseDto response = this.fakeStoreRetrofitCategoryApis.getAllCategories()
                .execute()
                .body();

        if(response == null){
            throw new IOException("Failed to fetch all categories");
        }

        return RetrofitGetAllCategoriesMapper.toCategoryDtoList(response);
    }
}
