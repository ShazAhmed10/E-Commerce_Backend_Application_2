package org.ecommerce_backend.ecommerce_backend_application_2.controllers;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws IOException {
        ProductDto response = this.productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
}
