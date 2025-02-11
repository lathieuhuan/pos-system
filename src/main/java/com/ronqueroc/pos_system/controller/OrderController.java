package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;
import com.ronqueroc.pos_system.service.order_service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

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
    public Object getOrder(@PathVariable int orderId) {
        return success(orderService.getDetailById(orderId));
    }

    @PostMapping
    public Object createNewOrder() {
        return success(orderService.createNewOrder());
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

//    @DeleteMapping("/{orderId}")
//    public void deleteOrder(@PathVariable int orderId) {
//        Order order = orderService.findById(orderId);
//
//        if (order == null) {
//            throw new RuntimeException("Order not found with id " + orderId);
//        }
//        orderService.deleteById(orderId);
//    }
}