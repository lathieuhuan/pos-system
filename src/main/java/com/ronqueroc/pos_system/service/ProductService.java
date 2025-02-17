package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.request.ProductSearchParam;
import com.ronqueroc.pos_system.response.product_response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<ProductResponse> search(ProductSearchParam param, Pageable pageable);

//    Product findById(Integer id);
//
//    List<Product> findAll();
//
//    Product save(Product product);
//
//    void deleteById(Integer id);
}
