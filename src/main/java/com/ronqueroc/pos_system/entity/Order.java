package com.ronqueroc.pos_system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ronqueroc.pos_system.constant.EOrderStatus;
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
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Convert(converter = EOrderStatus.Converter.class)
    private EOrderStatus status;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Collection<OrderItem> items;
}
