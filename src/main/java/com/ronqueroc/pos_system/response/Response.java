package com.ronqueroc.pos_system.response;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Response<T> implements Serializable {
    public ResponseMeta meta;
    public T data;
}
