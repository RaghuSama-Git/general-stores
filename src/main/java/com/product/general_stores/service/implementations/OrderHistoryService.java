package com.product.general_stores.service.implementations;

import com.product.general_stores.exception.UserNotFoundException;
import com.product.general_stores.model.OrderHistory;
import com.product.general_stores.repository.OrderHistoryRepository;
import com.product.general_stores.repository.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderHistoryService {

    private final UserLoginRepository loginRepo;
    private final OrderHistoryRepository orderHistoryRepo;

    public OrderHistoryService(UserLoginRepository loginRepo, OrderHistoryRepository orderHistoryRepo) {
        this.loginRepo = loginRepo;
        this.orderHistoryRepo = orderHistoryRepo;
    }

    public List<OrderHistory> getOrdersByUser(String email) throws UserNotFoundException {
        if(loginRepo.findByEmail(email).isPresent()){
            return orderHistoryRepo.findByUserId(email);
        }
        else {
            throw new UserNotFoundException("User not found with " + email);
        }
    }

    public OrderHistory placeNewOrder(OrderHistory orderDto) throws UserNotFoundException {
        Random random = new Random();

        if (loginRepo.findByEmail(orderDto.getUserId()).isPresent()) {

            orderDto.setOrderId(random.nextInt(1300000));
            orderDto.setLocalDateTime(LocalDateTime.now());
            return orderHistoryRepo.save(orderDto);
        }
        else {
            throw new UserNotFoundException("User not found with " + orderDto.getUserId());
        }
    }
}
