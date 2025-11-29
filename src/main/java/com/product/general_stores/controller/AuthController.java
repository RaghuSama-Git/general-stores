package com.product.general_stores.controller;

import com.product.general_stores.exception.InvalidCredentialsException;
import com.product.general_stores.exception.UserAlreadyExistsException;
import com.product.general_stores.model.UserLogin;
import com.product.general_stores.service.implementations.UserLoginService;
import com.product.general_stores.util.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserLoginService loginService;

    public AuthController(UserLoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/sign-up")
    public ResponseDTO<UserLogin> userSignUp(@RequestBody UserLogin user) throws UserAlreadyExistsException {
        ResponseDTO<UserLogin> responseDTO;

        if (user.getEmail().isEmpty() && user.getEmail() == null) {
            return new ResponseDTO<>("FAIL", null, "Email cannot be empty");
        } else if (user.getPassword().isEmpty() && user.getPassword() == null) {
            return new ResponseDTO<>("FAIL", null, "Password cannot be empty");
        } else {
            UserLogin savedUser = loginService.newUserLogin(user);
            return new ResponseDTO<>("SUCCESS", savedUser, "Signup successful !!");
        }
    }

    @PostMapping("/login")
    public ResponseDTO<UserLogin> userLogin(@RequestBody UserLogin user) throws InvalidCredentialsException {
        ResponseDTO<UserLogin> responseDTO;

        if (user.getEmail().isEmpty() && user.getEmail() == null) {
            return new ResponseDTO<>("FAIL", null, "Email cannot be empty");
        } else if (user.getPassword().isEmpty() && user.getPassword() == null) {
            return new ResponseDTO<>("FAIL", null, "Password cannot be empty");
        } else {
            UserLogin login = loginService.fetchUserByEmail(user.getEmail(), user.getPassword());
            return new ResponseDTO<>("SUCCESS", login, "Login successful !!");
        }
    }

    @GetMapping("/all-users")
    public ResponseDTO<List<UserLogin>> fetchAllUsers() {
        List<UserLogin> responseDTO;

        List<UserLogin> userLoginList = loginService.fetchAllUsers();

        if (userLoginList.isEmpty()) {
            return new ResponseDTO<>("FAIL", null, "No users found !!");
        } else {
            return new ResponseDTO<>("SUCCESS", userLoginList, "Users fetched successfully!!");
        }
    }
}
