package com.product.general_stores.service.implementations;

import com.product.general_stores.exception.InvalidCredentialsException;
import com.product.general_stores.exception.UserAlreadyExistsException;
import com.product.general_stores.model.UserLogin;
import com.product.general_stores.repository.UserLoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserLoginRepository loginRepo;

    public UserLoginService(PasswordEncoder passwordEncoder, UserLoginRepository loginRepo) {
        this.passwordEncoder = passwordEncoder;
        this.loginRepo = loginRepo;
    }

    public UserLogin newUserLogin(UserLogin user) throws UserAlreadyExistsException  {

        if (loginRepo.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("Email already exists");
        }
        else {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            return loginRepo.save(user);
        }
    }

    public UserLogin fetchUserByEmail(String email, String password) throws InvalidCredentialsException {
        UserLogin userDetails = loginRepo.findByEmail(email).get();
        if (email.equals(userDetails.getEmail()) && passwordEncoder.matches(password, userDetails.getPassword())){
            return userDetails;
        }
        else {
            throw new InvalidCredentialsException("Invalid login details");
        }
    }

    public List<UserLogin> fetchAllUsers(){
        return loginRepo.findAll();
    }
}
