package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService theOrderService) {
        orderService = theOrderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {

        Order order = orderService.findById(orderId);

        if (order == null) {
            throw new RuntimeException("Order not found with id" + orderId);
        }

        return order;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        order.setId(0);
        return orderService.save(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {

        Order order = orderService.findById(orderId);

        if (order == null) {
            throw new RuntimeException("Order not found with id " + orderId);
        }
        orderService.deleteById(orderId);
    }

}