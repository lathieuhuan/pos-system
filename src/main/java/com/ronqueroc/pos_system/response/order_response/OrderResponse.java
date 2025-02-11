package com.ronqueroc.pos_system.response.order_response;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {
    private int id;

    private EOrderStatus status;

    private OffsetDateTime createdAt;

    private Collection<OrderItemResponse> items;
}
