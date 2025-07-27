package org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.RetrofitFakeStoreProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreRetrofitProductApis {
    @GET("products/{id}")
    Call<RetrofitFakeStoreProductResponseDto> getProductById(@Path("id") Long id);
}
