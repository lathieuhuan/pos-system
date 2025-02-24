package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="products")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByCode(String code);
}
