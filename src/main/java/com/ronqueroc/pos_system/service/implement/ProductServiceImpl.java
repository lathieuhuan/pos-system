package com.ronqueroc.pos_system.service.implement;

import com.ronqueroc.pos_system.entity.Product;
import com.ronqueroc.pos_system.repository.ProductCustomRepository;
import com.ronqueroc.pos_system.repository.ProductRepository;
import com.ronqueroc.pos_system.request.ProductSearchParam;
import com.ronqueroc.pos_system.response.product_response.ProductResponse;
import com.ronqueroc.pos_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;
    private final ProductCustomRepository productCustomRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, ProductCustomRepository productCustomRepo) {
        this.productRepo = productRepo;
        this.productCustomRepo = productCustomRepo;
    }

    public ProductResponse toProductRes(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .build();
    }

    @Override
    public Page<ProductResponse> search(ProductSearchParam param, Pageable pageable) {
        Page<Product> productPage = productCustomRepo.findPaging(param, pageable);

        List<ProductResponse> productResList = productPage.getContent().stream()
                .map(product -> toProductRes(product))
                .collect(Collectors.toList());

        return new PageImpl<>(productResList, pageable, productPage.getTotalElements());
    }

//    @Override
//    public Product findById(Integer id) {
//        Optional<Product> result = productRepo.findById(id);
//
//        return result.orElse(null);
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return productRepo.findAll();
//    }
//
//    @Override
//    public Product save(Product product) {
//        return productRepo.save(product);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        productRepo.deleteById(id);
//    }
}
