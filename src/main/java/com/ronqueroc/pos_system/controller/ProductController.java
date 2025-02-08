package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.entity.Product;
import com.ronqueroc.pos_system.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);

        if (product == null) {
            throw new RuntimeException("Product not found with id " + productId);
        }
        return product;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(Product product) {
        Product savedProduct = productService.save(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);

        if (product == null) {
            throw new RuntimeException("Product not found with id " + productId);
        }
        productService.deleteById(productId);
    }
}
