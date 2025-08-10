package org.ecommerce_backend.ecommerce_backend_application_2.repositories;

import org.ecommerce_backend.ecommerce_backend_application_2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
