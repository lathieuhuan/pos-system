package com.ronqueroc.pos_system.projector;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.entity.OrderDraft;
import com.ronqueroc.pos_system.entity.OrderDraftItem;
import com.ronqueroc.pos_system.entity.OrderItem;
import com.ronqueroc.pos_system.response.OrderItemResponse;
import com.ronqueroc.pos_system.response.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OrderProjector {

    public static OrderResponse toResponse(OrderDraft order) {
        List<OrderItemResponse> orderItemResponses = order.getItems().stream()
                .map(ItemProjector::toResponse)
                .collect(Collectors.toList());

        return OrderResponse.builder()
                .code(order.getCode())
                .status(EOrderStatus.PROCESSING)
                .createdAt(order.getCreatedAt())
                .items(orderItemResponses)
                .build();
    }

    public static OrderResponse toResponse(Order order) {
        List<OrderItemResponse> orderItemResponses = order.getItems().stream()
                .map(ItemProjector::toResponse)
                .collect(Collectors.toList());

        return OrderResponse.builder()
                .code(order.getCode())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .items(orderItemResponses)
                .build();
    }

    public class ItemProjector {

        public static OrderItemResponse toResponse(OrderDraftItem orderItem) {
            return OrderItemResponse.builder()
                    .product(orderItem.getProduct())
                    .quantity(orderItem.getQuantity())
                    .build();
        }

        public static OrderItemResponse toResponse(OrderItem orderItem) {
            return OrderItemResponse.builder()
                    .product(orderItem.getProduct())
                    .quantity(orderItem.getQuantity())
                    .build();
        }
    }
}
