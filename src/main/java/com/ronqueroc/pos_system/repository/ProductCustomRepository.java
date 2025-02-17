package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.Product;
import com.ronqueroc.pos_system.request.ProductSearchParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProductCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public Page<Product> findPaging(ProductSearchParam param, Pageable pageable) {

        // Build SQL string query

        StringBuilder selectSql = new StringBuilder(200)
                .append("SELECT p FROM Product p");
        StringBuilder countSql = new StringBuilder(10)
                .append("SELECT COUNT(p.id) FROM Product p");

        StringBuilder whereClause = new StringBuilder(50)
                .append(" WHERE");

        if (param.getKeyword() != null) {
            whereClause.append(" p.name LIKE '%" + param.getKeyword() + "%'");
        }

        countSql.append(whereClause);
        selectSql.append(whereClause);

        // Count item

        TypedQuery<Long> countQuery = em.createQuery(countSql.toString(), Long.class);
        Long count = countQuery.getSingleResult();

        if (count == 0) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }

        TypedQuery<Product> pagingQuery = em.createQuery(selectSql.toString(), Product.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

//        pagingQuery.setParameter("keyword", "%" + param.getKeyword() + "%");

        return new PageImpl(pagingQuery.getResultList(), pageable, count);
    }
}
