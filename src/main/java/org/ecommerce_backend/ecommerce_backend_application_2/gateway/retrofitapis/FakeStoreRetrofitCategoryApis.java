package org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RetrofitFakeStoreCategoryResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakeStoreRetrofitCategoryApis {
    @GET("products/category")
    Call<RetrofitFakeStoreCategoryResponseDto> getAllCategories() throws IOException;
}
