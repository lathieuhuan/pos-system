package com.ronqueroc.pos_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

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

    @Column(unique = true)
    private String code;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "orderDraft", fetch = FetchType.EAGER)
    private Collection<OrderDraftItem> items;

    @PrePersist
    public void generateCode() {
        if (this.code == null) {
            this.code = "OD_" + UUID.randomUUID().toString().replace("-", "");
        }
    }
}
