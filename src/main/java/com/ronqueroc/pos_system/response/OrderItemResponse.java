package com.ronqueroc.pos_system.response;

import com.ronqueroc.pos_system.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderItemResponse {

    private Product product;

    private Integer quantity;
}
    