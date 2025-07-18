package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.gateway.CategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{

    private final CategoryGateway categoryGateway;

    public FakeStoreCategoryServiceImpl(CategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
}
