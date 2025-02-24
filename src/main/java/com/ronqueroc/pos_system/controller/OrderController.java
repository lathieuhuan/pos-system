package com.ronqueroc.pos_system.controller;

import com.ronqueroc.pos_system.request.OrderDraftItemAddParam;
import com.ronqueroc.pos_system.request.OrderDraftItemUpdateParam;
import com.ronqueroc.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderCode}")
    public Object getOrder(@PathVariable String orderCode) {
        return success(orderService.getOrderByCode(orderCode));
    }

    @PostMapping
    public Object createNewOrder() {
        return success(orderService.createOrderDraft());
    }

    @DeleteMapping("/{orderCode}")
    public Object deleteOrderDraft(@PathVariable String orderCode) {
        orderService.deleteOrderDraftByCode(orderCode);
        return success();
    }

    @PostMapping("/{orderCode}/items")
    public Object addDraftItem(@PathVariable String orderCode, @RequestBody OrderDraftItemAddParam param) {
        return success(orderService.addDraftItem(orderCode, param.getProductCode()));
    }

    @PutMapping("/{orderCode}/items/{productCode}")
    public Object updateOrderItemQuantity(
            @PathVariable String orderCode,
            @PathVariable String productCode,
            @RequestBody OrderDraftItemUpdateParam param
    ) {
        return success(orderService.updateDraftItemQuantity(orderCode, productCode, param.getQuantity()));
    }

    @DeleteMapping("/{orderCode}/items/{productCode}")
    public Object deleteDraftItem(@PathVariable String orderCode, @PathVariable String productCode) {
        orderService.deleteDraftItem(orderCode, productCode);
        return success();
    }
}