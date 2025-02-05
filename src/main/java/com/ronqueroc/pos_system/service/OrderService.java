package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.entity.Order;

import java.util.List;

public interface OrderService {
    Order findById(Integer id);

    List<Order> findAll();

    Order save(Order order);

    void deleteById(Integer id);
}
