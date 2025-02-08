package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

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
            throw new RuntimeException("Order not found with id " + orderId);
        }
        return order;
    }

    @PostMapping
    public ResponseEntity<Order> createNewOrder() {
        Order order = Order.builder().status(EOrderStatus.PROCESSING).build();
        Order savedOrder = orderService.save(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
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