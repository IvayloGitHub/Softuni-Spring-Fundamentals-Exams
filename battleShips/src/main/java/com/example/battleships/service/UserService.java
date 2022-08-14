package com.example.battleships.service;

import com.example.battleships.model.entity.UserEntity;
import com.example.battleships.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);

    UserEntity findUserById(Long id);
}
