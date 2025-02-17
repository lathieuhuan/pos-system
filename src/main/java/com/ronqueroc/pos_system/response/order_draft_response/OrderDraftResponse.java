package com.ronqueroc.pos_system.response.order_draft_response;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDraftResponse {
    private int id;

    private OffsetDateTime createdAt;

    private Collection<OrderDraftItemResponse> items;
}
