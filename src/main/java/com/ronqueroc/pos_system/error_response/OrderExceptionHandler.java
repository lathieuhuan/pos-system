package com.ronqueroc.pos_system.error_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<OrderErrorResponse> handleException(RuntimeException exception) {
        OrderErrorResponse error = new OrderErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
