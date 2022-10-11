package com.example.likebookapp.service;

import com.example.likebookapp.model.entity.UserEntity;
import com.example.likebookapp.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);

    UserEntity findUserById(Long id);
}
