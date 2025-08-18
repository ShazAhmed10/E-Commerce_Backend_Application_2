package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductCategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;

public interface ProductService {
    public ProductDto getProductById(Long id) throws Exception;

    public ProductDto createProduct(ProductDto productDto) throws Exception;

    public ProductCategoryDto getProductWithCategory(long id) throws Exception;
}
