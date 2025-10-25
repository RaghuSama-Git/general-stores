package com.product.general_stores.repository;

import com.product.general_stores.model.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, String> {

    List<OrderHistory> findByUserId(String emil);

}
