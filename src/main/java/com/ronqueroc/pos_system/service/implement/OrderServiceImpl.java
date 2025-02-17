package com.ronqueroc.pos_system.service.implement;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.entity.OrderDraft;
import com.ronqueroc.pos_system.exception.DataNotFoundException;
import com.ronqueroc.pos_system.repository.OrderDraftRepository;
import com.ronqueroc.pos_system.repository.OrderRepository;
import com.ronqueroc.pos_system.response.order_draft_response.OrderDraftItemResponse;
import com.ronqueroc.pos_system.response.order_draft_response.OrderDraftResponse;
import com.ronqueroc.pos_system.response.order_response.OrderItemResponse;
import com.ronqueroc.pos_system.response.order_response.OrderResponse;
import com.ronqueroc.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDraftRepository orderDraftRepo;
    private final OrderRepository orderRepo;

    @Autowired
    public OrderServiceImpl(OrderDraftRepository orderDraftRepo, OrderRepository orderRepo) {
        this.orderDraftRepo = orderDraftRepo;
        this.orderRepo = orderRepo;
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

//    @Override
//    public List<Order> findAll() {
//        return orderRepo.findAll();
//    }


    @Override
    public OrderDraft saveDraft(OrderDraft order) {
        return orderDraftRepo.save(order);
    }

//    @Override
//    public Order save(Order order) {
//        return orderRepo.save(order);
//    }

//    @Override
//    public void deleteById(Integer id) {
//        orderRepo.deleteById(id);
//    }

    @Override
    public OrderDraftResponse createOrderDraft() {
        OrderDraft order = OrderDraft.builder()
                .createdAt(OffsetDateTime.now())
                .items(List.of())
                .build();

        saveDraft(order);

        List<OrderDraftItemResponse> items = order.getItems().stream()
                .map((e) -> OrderDraftItemResponse.builder()
                        .product(e.getProduct())
                        .quantity(e.getQuantity())
                        .build())
                .collect(Collectors.toList());

        OrderDraftResponse orderRes = OrderDraftResponse.builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .items(items)
                .build();

        return orderRes;
    }
}
