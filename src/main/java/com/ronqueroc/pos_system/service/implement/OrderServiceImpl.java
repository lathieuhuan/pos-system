package com.ronqueroc.pos_system.service.implement;

import com.ronqueroc.pos_system.entity.Order;
import com.ronqueroc.pos_system.entity.OrderDraft;
import com.ronqueroc.pos_system.entity.OrderDraftItem;
import com.ronqueroc.pos_system.entity.Product;
import com.ronqueroc.pos_system.exception.DataNotFoundException;
import com.ronqueroc.pos_system.projector.OrderItemProjector;
import com.ronqueroc.pos_system.projector.OrderProjector;
import com.ronqueroc.pos_system.repository.OrderDraftItemRepository;
import com.ronqueroc.pos_system.repository.OrderDraftRepository;
import com.ronqueroc.pos_system.repository.OrderRepository;
import com.ronqueroc.pos_system.repository.ProductRepository;
import com.ronqueroc.pos_system.response.OrderItemResponse;
import com.ronqueroc.pos_system.response.OrderResponse;
import com.ronqueroc.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;
    private final OrderDraftRepository orderDraftRepo;
    private final OrderDraftItemRepository orderDraftItemRepo;
    private final ProductRepository productRepo;

    @Autowired
    public OrderServiceImpl(
            OrderRepository orderRepo,
            OrderDraftRepository orderDraftRepo,
            OrderDraftItemRepository orderDraftItemRepo,
            ProductRepository productRepo
    ) {
        this.orderRepo = orderRepo;
        this.orderDraftRepo = orderDraftRepo;
        this.orderDraftItemRepo = orderDraftItemRepo;
        this.productRepo = productRepo;
    }

    private Boolean isOrderDraft(String code) {
        return code.split("_")[0].equals("OD");
    }

    private OrderDraft getOrderDraftByCode(String code) {
        return orderDraftRepo.findByCode(code).orElseThrow(() -> new DataNotFoundException());
    }

    @Override
    public OrderResponse getOrderByCode(String code) {
        if (isOrderDraft(code)) {
            OrderDraft order = getOrderDraftByCode(code);
            return OrderProjector.toResponse(order);
        }

        Order order = orderRepo.findByCode(code).orElseThrow(() -> new DataNotFoundException());
        return OrderProjector.toResponse(order);
    }

    @Override
    public OrderResponse createOrderDraft() {
        OrderDraft orderDraft = OrderDraft.builder()
                .createdAt(OffsetDateTime.now())
                .items(List.of())
                .build();

        OrderDraft savedOrderDraft = orderDraftRepo.save(orderDraft);

        return OrderProjector.toResponse(savedOrderDraft);
    }

    @Override
    public void deleteOrderDraftByCode(String code) {
        if (isOrderDraft(code)) {
            OrderDraft orderDraft = getOrderDraftByCode(code);
            orderDraftRepo.delete(orderDraft);
        } else {
            throw new RuntimeException("This Order cannot be deleted.");
        }
    }

    @Override
    public OrderItemResponse addDraftItem(String orderCode, String productCode) {
        OrderDraft orderDraft = orderDraftRepo.findByCode(orderCode).orElseThrow(() -> new DataNotFoundException());
        Product product = productRepo.findByCode(productCode).orElseThrow(() -> new DataNotFoundException());
        OrderDraftItem draftItem = OrderDraftItem.builder()
                .orderDraft(orderDraft)
                .product(product)
                .quantity(1)
                .build();

        OrderDraftItem savedDraftItem = orderDraftItemRepo.save(draftItem);

        return OrderItemProjector.toResponse(savedDraftItem);
    }
    
    private OrderDraftItem findOrderDratItem(String orderCode, String productCode) {
        return orderDraftItemRepo.findByOrderDraftCodeAndProductCode(orderCode, productCode)
                .orElseThrow(() -> new DataNotFoundException());
    }

    @Override
    public OrderItemResponse updateDraftItemQuantity(String orderCode, String productCode, Integer quantity) {
        OrderDraftItem item = findOrderDratItem(orderCode, productCode);
        item.setQuantity(quantity);
        OrderDraftItem updatedItem = orderDraftItemRepo.save(item);

        return OrderItemProjector.toResponse(updatedItem);
    }

    @Override
    public void deleteDraftItem(String orderCode, String productCode) {
        OrderDraftItem item = findOrderDratItem(orderCode, productCode);
        orderDraftItemRepo.delete(item);
    }
}
