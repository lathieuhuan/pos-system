package com.ronqueroc.pos_system.controller.response;

import com.ronqueroc.pos_system.response.OrderItemResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderItemUpdateResponse extends OrderItemResponse {

    private String orderCode;

}
