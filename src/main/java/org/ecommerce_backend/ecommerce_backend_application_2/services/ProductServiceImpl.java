package org.ecommerce_backend.ecommerce_backend_application_2.services;

import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductCategoryDto;
import org.ecommerce_backend.ecommerce_backend_application_2.dtos.ProductDto;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;
import org.ecommerce_backend.ecommerce_backend_application_2.entity.Product;
import org.ecommerce_backend.ecommerce_backend_application_2.mappers.ProductMapper;
import org.ecommerce_backend.ecommerce_backend_application_2.repositories.CategoryRepository;
import org.ecommerce_backend.ecommerce_backend_application_2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductDto getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(Exception::new);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws Exception {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new Exception("There is no valid category for the given category_id"));

        Product savedProduct = productRepository.save(ProductMapper.toEntity(productDto, category));
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public ProductCategoryDto getProductWithCategory(long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper :: toProductCategoryDto)
                .orElseThrow(() -> new Exception("There is no valid product for the given product_id"));
    }
}
