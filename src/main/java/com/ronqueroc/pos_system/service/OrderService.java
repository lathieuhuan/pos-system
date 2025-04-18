package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.controller.response.OrderItemDeleteResponse;
import com.ronqueroc.pos_system.response.OrderItemResponse;
import com.ronqueroc.pos_system.response.OrderResponse;

public interface OrderService {

    OrderResponse getOrderByCode(String code);

    OrderResponse createOrderDraft();

    void deleteOrderDraftByCode(String code);

    OrderItemResponse addDraftItem(String orderCode, String productCode);

    OrderItemResponse updateDraftItemQuantity(String orderCode, String productCode, Integer quantity);

    OrderItemDeleteResponse deleteDraftItem(String orderCode, String productCode);
}
