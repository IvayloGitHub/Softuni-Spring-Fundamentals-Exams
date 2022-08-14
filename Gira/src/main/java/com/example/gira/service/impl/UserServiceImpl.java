package com.example.gira.service.impl;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.sec.CurrentUser;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String email) {
        currentUser.setId(id);
        currentUser.setEmail(email);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }
}
