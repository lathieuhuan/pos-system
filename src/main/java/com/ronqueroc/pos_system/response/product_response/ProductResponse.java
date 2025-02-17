package com.ronqueroc.pos_system.response.product_response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {
    private int id;

    private String name;

    private String code;

    private Integer price;

    private String unit;
}
