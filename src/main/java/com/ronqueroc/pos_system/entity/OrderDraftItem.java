package com.ronqueroc.pos_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_draft_item")
public class OrderDraftItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderDraftCode", referencedColumnName = "code")
    private OrderDraft orderDraft;

    @ManyToOne
    @JoinColumn(name = "productCode", referencedColumnName = "code")
    private Product product;

    private Integer quantity;
}
