package org.ecommerce_backend.ecommerce_backend_application_2.configurations;

import org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis.FakeStoreRetrofitApis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class FakeStoreRetrofitConfig {
    @Bean
    public Retrofit retrofit(){
        return new Retrofit
                .Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreRetrofitApis fakeStoreRetrofitApis(Retrofit retrofit){
        return retrofit.create(FakeStoreRetrofitApis.class);
    }
}
