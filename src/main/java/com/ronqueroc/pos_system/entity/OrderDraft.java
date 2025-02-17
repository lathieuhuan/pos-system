package com.ronqueroc.pos_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Collection;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_draft")
public class OrderDraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "orderDraft", fetch = FetchType.EAGER)
    private Collection<OrderDraftItem> items;
}
