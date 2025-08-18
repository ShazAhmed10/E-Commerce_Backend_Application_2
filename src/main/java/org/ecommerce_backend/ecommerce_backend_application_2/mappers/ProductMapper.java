package org.ecommerce_backend.ecommerce_backend_application_2.mappers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductCategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .categoryId(product.getCategory().getId())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDto productDto, Category category){
        return Product.builder()
                .image(productDto.getImage())
                .color(productDto.getColor())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .discount(productDto.getDiscount())
                .model(productDto.getModel())
                .title(productDto.getTitle())
                .brand(productDto.getBrand())
                .category(category)
                .popular(productDto.isPopular())
                .build();
    }

    public static ProductCategoryDto toProductCategoryDto(Product product){
        return ProductCategoryDto.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .categoryDto(CategoryMapper.toDto(product.getCategory()))
                .popular(product.isPopular())
                .build();
    }
}
