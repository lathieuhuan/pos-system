package com.ronqueroc.pos_system.service;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository theOrderRepository) {
        orderRepository = theOrderRepository;
    }

    @Override
    public Order findById(Integer id) {
        Optional<Order> result = orderRepository.findById(id);

        return result.orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
