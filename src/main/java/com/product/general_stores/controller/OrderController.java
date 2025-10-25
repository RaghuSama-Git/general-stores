package com.product.general_stores.controller;

import com.product.general_stores.model.OrderHistory;
import com.product.general_stores.service.implementations.OrderHistoryService;
import com.product.general_stores.util.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderHistoryService orderService;

    public OrderController(OrderHistoryService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{email}")
    public ResponseDTO<List<OrderHistory>> getOrdersByUser(@PathVariable String email){
        ResponseDTO<List<OrderHistory>> responseDTO;

        List<OrderHistory> orderHistoryList = orderService.getOrdersByUser(email);
        return new ResponseDTO<>("SUCCESS", orderHistoryList, "Order history fetched successfully !!");
    }

    @PostMapping("/place-new-order")
    public ResponseDTO<OrderHistory> placeNewOrder(@RequestBody OrderHistory orderHistory){
        ResponseDTO<List<OrderHistory>> responseDTO;

        OrderHistory orderHistoryList = orderService.placeNewOrder(orderHistory);
        return new ResponseDTO<>("SUCCESS", orderHistoryList, "Order placed successfully !!");
    }

}
