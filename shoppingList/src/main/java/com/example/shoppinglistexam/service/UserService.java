package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);
}
