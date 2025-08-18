package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto{
    private long id;
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private String title;
	private Long categoryId;
	private String brand;
	private boolean popular;
}
