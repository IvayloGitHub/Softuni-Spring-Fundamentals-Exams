package com.example.battleships.service.impl;

import com.example.battleships.model.entity.UserEntity;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.UserService;
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
    public UserServiceModel findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
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
}
