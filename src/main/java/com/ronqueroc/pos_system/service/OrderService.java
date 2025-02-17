package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.entity.OrderDraft;
import com.ronqueroc.pos_system.response.order_draft_response.OrderDraftResponse;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(Integer id);

    OrderResponse getDetailById(Integer id);

//    List<Order> findAll();

    OrderDraftResponse createOrderDraft();

    OrderDraft saveDraft(OrderDraft order);

//    Order save(Order order);

//    void deleteById(Integer id);
}
