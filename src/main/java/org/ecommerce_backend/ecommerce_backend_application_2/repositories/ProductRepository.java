package org.ecommerce_backend.ecommerce_backend_application_2.repositories;

import org.ecommerce_backend.ecommerce_backend_application_2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Example of using HQL or JPQL
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double price);

    //Examples of using native query language i.e. SQL
    @Query(value = "SELECT * FROM product WHERE MATCH(brand, description) AGAINST(:keyword)", nativeQuery = true)
    List<Product> SearchFullText(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM product WHERE price >= :minPrice AND brand = :brand", nativeQuery = true)
    List<Product> findProductByMinPriceAndBrand(
            @Param("minPrice") double minPrice,
            @Param("brand") String brand
    );
}