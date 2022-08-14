package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.UserEntity;
import com.example.coffeeshopexam.model.service.UserServiceModel;
import com.example.coffeeshopexam.model.view.UserViewModel;
import com.example.coffeeshopexam.repository.UserRepository;
import com.example.coffeeshopexam.sec.CurrentUser;
import com.example.coffeeshopexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userEntity -> this.modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> orderEmploysByTheCountOfTheirOrders() {
        return userRepository.orderEmployeesByCountOfOrders()
                .stream()
                .map(userEntity -> {
                    UserViewModel userViewModel = modelMapper.map(userEntity, UserViewModel.class);
                    userViewModel.setNumberOfOrders(userEntity.getOrders().size());
                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
