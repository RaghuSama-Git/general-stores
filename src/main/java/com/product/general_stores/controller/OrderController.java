package com.product.general_stores.controller;

import com.product.general_stores.exception.UserNotFoundException;
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
    public ResponseDTO<List<OrderHistory>> getOrdersByUser(@PathVariable String email) throws UserNotFoundException {
        ResponseDTO<List<OrderHistory>> responseDTO;

        List<OrderHistory> userId = orderService.getOrdersByUser(email);
        if(userId.isEmpty()){
            return new ResponseDTO<>("FAIL", null, "No Order history found! please make your first order");
        }
        return new ResponseDTO<>("SUCCESS", userId, "Order history fetched successfully !!");
    }

    @PostMapping("/place-new-order")
    public ResponseDTO<OrderHistory> placeNewOrder(@RequestBody OrderHistory orderHistory) throws UserNotFoundException {
        ResponseDTO<List<OrderHistory>> responseDTO;

        OrderHistory orderHistoryList = orderService.placeNewOrder(orderHistory);
        return new ResponseDTO<>("SUCCESS", orderHistoryList, "Order placed successfully !!");
    }

}
