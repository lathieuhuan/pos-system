package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.request.ProductSearchParam;
import com.ronqueroc.pos_system.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Page<ProductResponse> search(ProductSearchParam param, Pageable pageable);
}
