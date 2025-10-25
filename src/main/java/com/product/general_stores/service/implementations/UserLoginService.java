package com.product.general_stores.service.implementations;

import com.product.general_stores.model.UserLogin;
import com.product.general_stores.repository.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginService {

    private final UserLoginRepository loginRepo;

    public UserLoginService(UserLoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public UserLogin newUserLogin(UserLogin userLogin){
        return loginRepo.save(userLogin);
    }

    public UserLogin fetchUserByEmail(String email, String password) throws Exception {
        UserLogin userDetails = loginRepo.findByEmailAndPassword(email, password);

        if (email.equals(userDetails.getEmail()) && password.equals(userDetails.getPassword())){
            return userDetails;
        }
        else {
            throw new Exception("Invalid login details");
        }
    }

    public List<UserLogin> fetchAllUsers(){
        return loginRepo.findAll();
    }
}
