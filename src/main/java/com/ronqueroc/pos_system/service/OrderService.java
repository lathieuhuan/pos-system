package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.response.order_response.OrderItemResponse;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;

public interface OrderService {

    OrderResponse getDetailByCode(String code);

    OrderResponse createOrderDraft();

    OrderItemResponse addDraftItem(String orderCode, Integer productId);

    OrderItemResponse updateDraftItemQuantity(String orderCode, Integer productId, Integer quantity);
    
    void deleteDraftItem(String orderCode, Integer productId);
}
