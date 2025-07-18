package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.FakeStoreProductResponseDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.retrofitapis.FakeStoreRetrofitProductApis;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductGatewayImpl implements ProductGateway{
    private final FakeStoreRetrofitProductApis fakeStoreRetrofitProductApis;

    public FakeStoreProductGatewayImpl(FakeStoreRetrofitProductApis fakeStoreRetrofitProductApis){
        this.fakeStoreRetrofitProductApis = fakeStoreRetrofitProductApis;
    }

    @Override
    public ProductDto getProductById(Long id) throws IOException {
        FakeStoreProductResponseDto response = this.fakeStoreRetrofitProductApis.getProductById(id)
                .execute()
                .body();

        if(response == null) {
            throw new IOException("Failed to fetch the product");
        }

        return response.getProduct();
    }
}
