package com.product.general_stores.repository;

import com.product.general_stores.model.GetInTouch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GetInTouchRepository extends MongoRepository<GetInTouch, String> {
}
