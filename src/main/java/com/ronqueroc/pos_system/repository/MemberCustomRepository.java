package com.ronqueroc.pos_system.repository;

import com.ronqueroc.pos_system.entity.Member;
import com.ronqueroc.pos_system.request.MemberSearchParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class MemberCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public Page<Member> findPaging(MemberSearchParam param, Pageable pageable) {

        // Build SQL string query

        StringBuilder selectSql = new StringBuilder(200)
                .append("SELECT m FROM Member m");
        StringBuilder countSql = new StringBuilder(10)
                .append("SELECT COUNT(m.id) FROM Member m");

        StringBuilder whereClause = new StringBuilder(50);

        if (param.getKeyword() != null) {
            whereClause.append(" m.name LIKE '%" + param.getKeyword() + "%'");
        }

        if (!whereClause.isEmpty()) {
            whereClause.insert(0, " WHERE");
        }

        countSql.append(whereClause);
        selectSql.append(whereClause);

        // Count item

        TypedQuery<Long> countQuery = em.createQuery(countSql.toString(), Long.class);
        Long count = countQuery.getSingleResult();

        if (count == 0) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }

        TypedQuery<Member> pagingQuery = em.createQuery(selectSql.toString(), Member.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        return new PageImpl(pagingQuery.getResultList(), pageable, count);
    }
}
