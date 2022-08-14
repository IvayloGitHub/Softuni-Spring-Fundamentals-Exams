package com.example.musicdbexam.service;

import com.example.musicdbexam.model.entity.UserEntity;
import com.example.musicdbexam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);

    UserEntity findUserById(Long id);
}
