package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;

import java.io.IOException;

public interface ProductGateway {
    public ProductDto getProductById(Long id) throws IOException;
}
