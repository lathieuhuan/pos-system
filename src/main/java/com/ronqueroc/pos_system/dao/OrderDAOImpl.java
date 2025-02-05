package com.ronqueroc.pos_system.dao;

import com.ronqueroc.pos_system.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    private EntityManager entityManager;

    @Autowired
    public OrderDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Order findById(Integer id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> theQuery = entityManager.createQuery("FROM Order", Order.class);
        return theQuery.getResultList();
    }

    @Override
    public void add(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public void deleteById(Integer id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
    }
}
