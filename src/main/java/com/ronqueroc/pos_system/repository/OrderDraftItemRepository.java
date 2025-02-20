package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.OrderDraftItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="order_draft_items")
public interface OrderDraftItemRepository extends JpaRepository<OrderDraftItem, Integer> {
}
