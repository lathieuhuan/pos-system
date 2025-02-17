package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.entity.Product;
import com.ronqueroc.pos_system.request.ProductSearchParam;
import com.ronqueroc.pos_system.response.product_response.ProductResponse;
import com.ronqueroc.pos_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @SortDefault(sort = "requestCreatedAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        ProductSearchParam param = ProductSearchParam.builder()
                .keyword(keyword)
                .build();

        return success(productService.search(param, pageable));
    }

//    @GetMapping("/{productId}")
//    public Product getProduct(@PathVariable int productId) {
//        Product product = productService.findById(productId);
//
//        if (product == null) {
//            throw new RuntimeException("Product not found with id " + productId);
//        }
//        return product;
//    }

//    @PostMapping
//    public ResponseEntity<Product> addProduct(Product product) {
//        Product savedProduct = productService.save(product);
//
//        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
//    }

//    @PutMapping
//    public Product updateProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }

//    @DeleteMapping("/{productId}")
//    public void deleteProduct(@PathVariable int productId) {
//        Product product = productService.findById(productId);
//
//        if (product == null) {
//            throw new RuntimeException("Product not found with id " + productId);
//        }
//        productService.deleteById(productId);
//    }
}
