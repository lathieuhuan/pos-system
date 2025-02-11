package com.ronqueroc.pos_system.service.order_service;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(Integer id);

    OrderResponse getDetailById(Integer id);

    List<Order> findAll();

    OrderResponse createNewOrder();

    Order save(Order order);

    void deleteById(Integer id);
}
