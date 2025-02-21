package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.response.Response;
import com.ronqueroc.pos_system.response.ResponseMeta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<Response> success() {
        return new ResponseEntity<>(new Response<>(new ResponseMeta(), null), HttpStatus.OK);
    }

    protected ResponseEntity<Response> success(Object data) {
        return new ResponseEntity<>(new Response<>(new ResponseMeta(), data), HttpStatus.OK);
    }

    protected ResponseEntity<Response> notFound(String message) {
        return new ResponseEntity<>(new Response<>(new ResponseMeta(404, message), null), HttpStatus.NOT_FOUND);
    }
}
