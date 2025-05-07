package com.versetti.ProductsManagement.repositories;

import com.versetti.ProductsManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
