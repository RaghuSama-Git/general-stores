package com.product.general_stores.repository;

import com.product.general_stores.model.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserLoginRepository extends MongoRepository<UserLogin, String> {

    UserLogin findByEmailAndPassword(String email, String password);

}
