package com.ronqueroc.pos_system.entity;

import com.ronqueroc.pos_system.constant.EOrderStatus;
import jakarta.persistence.*;
import lombok.*;

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
}
