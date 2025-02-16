package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="orders")
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
