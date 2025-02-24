package com.ronqueroc.pos_system.projector;

import com.ronqueroc.pos_system.entity.OrderDraftItem;
import com.ronqueroc.pos_system.entity.OrderItem;
import com.ronqueroc.pos_system.response.OrderItemResponse;

public class OrderItemProjector {

    public static OrderItemResponse toResponse(OrderDraftItem orderItem) {
        return OrderItemResponse.builder()
                .orderCode(orderItem.getOrderDraft().getCode())
                .product(orderItem.getProduct())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public static OrderItemResponse toResponse(OrderItem orderItem) {
        return OrderItemResponse.builder()
                .orderCode(orderItem.getOrder().getCode())
                .product(orderItem.getProduct())
                .quantity(orderItem.getQuantity())
                .build();
    }
}
