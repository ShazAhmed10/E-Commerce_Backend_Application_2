package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private final ProductGateway productGateway;

    public FakeStoreProductServiceImpl(ProductGateway productGateway){
        this.productGateway = productGateway;
    }

    @Override
    public ProductDto getProductById(Long id) throws IOException {
        return this.productGateway.getProductById(id);
    }
}
