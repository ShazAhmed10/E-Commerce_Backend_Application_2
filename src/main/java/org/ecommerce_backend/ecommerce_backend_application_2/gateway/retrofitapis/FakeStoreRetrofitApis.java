package org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreCategoryResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakeStoreRetrofitApis {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDto> getAllCategories() throws IOException;
}
