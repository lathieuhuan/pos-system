package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.OrderDraftItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource(path="order_draft_items")
public interface OrderDraftItemRepository extends JpaRepository<OrderDraftItem, Integer> {
    @Transactional
    Optional<OrderDraftItem> findByOrderDraftCodeAndProductCode(String orderCode, String productCode);
}
