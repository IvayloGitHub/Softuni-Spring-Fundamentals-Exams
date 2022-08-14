package com.example.coffeeshopexam.service;

import com.example.coffeeshopexam.model.entity.UserEntity;
import com.example.coffeeshopexam.model.service.UserServiceModel;
import com.example.coffeeshopexam.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);

    UserEntity findUserById(Long id);

    List<UserViewModel> orderEmploysByTheCountOfTheirOrders();

}
