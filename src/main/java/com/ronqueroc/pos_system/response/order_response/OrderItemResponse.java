package com.ronqueroc.pos_system.response.order_response;

import com.ronqueroc.pos_system.entity.Product;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderItemResponse {

    private Product product;

    private Integer quantity;
}
