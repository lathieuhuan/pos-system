package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.request.ProductSearchParam;
import com.ronqueroc.pos_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Object search(
            @RequestParam(required = false) String keyword,
            @SortDefault Pageable pageable
    ) {
        ProductSearchParam param = ProductSearchParam.builder()
                .keyword(keyword)
                .build();

        return success(productService.search(param, pageable));
    }
}
