package org.ecommerce_backend.ecommerce_backend_application_2.gateway;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryGateway {
    public List<CategoryDto> getAllCategories() throws IOException;
}
