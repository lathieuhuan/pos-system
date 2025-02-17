package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.OrderDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="order_drafts")
public interface OrderDraftRepository extends JpaRepository<OrderDraft, Integer> {
}
