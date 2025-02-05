package com.ronqueroc.pos_system.dao;

import com.ronqueroc.pos_system.entity.Order;

import java.util.List;

public interface OrderDAO {

    Order findById(Integer id);

    List<Order> findAll();

    void add(Order order);

    Order update(Order order);

    void deleteById(Integer id);
}
