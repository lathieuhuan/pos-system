package com.ronqueroc.pos_system.service.order_service;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.exception.DataNotFoundException;
import com.ronqueroc.pos_system.repository.OrderRepository;
import com.ronqueroc.pos_system.response.order_response.OrderItemResponse;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepository theOrderRepository) {
        orderRepo = theOrderRepository;
    }

    private OrderResponse toResponse(Order order) {
        List<OrderItemResponse> orderItemResponses = order.getItems().stream()
                .map((e) -> OrderItemResponse.builder()
                        .product(e.getProduct())
                        .quantity(e.getQuantity())
                        .build())
                .collect(Collectors.toList());

        OrderResponse orderRes = OrderResponse.builder()
                .id(order.getId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .items(orderItemResponses)
                .build();

        return orderRes;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepo.findById(id);
    }

    @Override
    public OrderResponse getDetailById(Integer id) {
        Order order = findById(id).orElseThrow(() -> new DataNotFoundException());

        return toResponse(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepo.deleteById(id);
    }

    @Override
    public OrderResponse createNewOrder() {
        Order order = Order.builder()
                .status(EOrderStatus.PROCESSING)
                .createdAt(OffsetDateTime.now())
                .items(List.of())
                .build();

        save(order);
        return toResponse(order);
    }
}
