package com.example.gira.service;


import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByEmail(String email);

    void loginUser(Long id, String email);

    UserEntity findUserById(Long id);
}
