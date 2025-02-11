package com.ronqueroc.pos_system.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseMeta implements Serializable {
    public int code = 200;
    public String message = "Success";
}
