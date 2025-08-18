package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryDto {
    private long id;
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private CategoryDto categoryDto;
    private String brand;
    private boolean popular;
}
