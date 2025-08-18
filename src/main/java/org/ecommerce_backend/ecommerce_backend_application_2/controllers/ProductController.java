package org.ecommerce_backend.ecommerce_backend_application_2.controllers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductCategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Qualifier("productServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws Exception {
        ProductDto response = this.productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) throws Exception {
        ProductDto response = productService.createProduct(productDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductCategoryDto> getProductWithCategory(@PathVariable long id) throws Exception{
        ProductCategoryDto response = productService.getProductWithCategory(id);
        return ResponseEntity.ok(response);
    }
}
