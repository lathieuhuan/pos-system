package com.ronqueroc.pos_system.service.product_service;

import com.ronqueroc.pos_system.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(Integer id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Integer id);
}
