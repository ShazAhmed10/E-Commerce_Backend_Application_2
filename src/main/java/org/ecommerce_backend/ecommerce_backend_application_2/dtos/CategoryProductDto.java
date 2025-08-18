package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryProductDto {
    private long id;
    private String name;
    private List<ProductDto> productDtoList;
}
