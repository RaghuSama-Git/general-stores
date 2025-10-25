package com.product.general_stores.service.implementations;

import com.product.general_stores.model.OrderHistory;
import com.product.general_stores.repository.OrderHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepo;

    public OrderHistoryService(OrderHistoryRepository orderHistoryRepo) {
        this.orderHistoryRepo = orderHistoryRepo;
    }

    public List<OrderHistory> getOrdersByUser(String email) {
        return orderHistoryRepo.findByUserId(email);
    }

    public OrderHistory placeNewOrder(OrderHistory orderDto){
        Random random = new Random();
        orderDto.setOrderId(random.nextInt(1300000));
        orderDto.setLocalDateTime(LocalDateTime.now());
        return orderHistoryRepo.save(orderDto);
    }


}
