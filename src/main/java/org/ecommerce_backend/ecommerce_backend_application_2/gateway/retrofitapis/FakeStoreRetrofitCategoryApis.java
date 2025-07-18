package org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreCategoryResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreRetrofitCategoryApis {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDto> getAllCategories() throws IOException;
}
