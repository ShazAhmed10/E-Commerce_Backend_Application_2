package org.ecommerce_backend.ecommerce_backend_application_2.repositories;

import org.ecommerce_backend.ecommerce_backend_application_2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String categoryName);
}
