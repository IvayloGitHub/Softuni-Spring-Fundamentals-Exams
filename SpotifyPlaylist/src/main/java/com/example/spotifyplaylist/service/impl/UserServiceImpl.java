package com.example.spotifyplaylist.service.impl;

import com.example.spotifyplaylist.model.entity.SongEntity;
import com.example.spotifyplaylist.model.entity.UserEntity;
import com.example.spotifyplaylist.model.service.UserServiceModel;
import com.example.spotifyplaylist.model.view.SongViewModel;
import com.example.spotifyplaylist.repository.UserRepository;
import com.example.spotifyplaylist.sec.CurrentUser;
import com.example.spotifyplaylist.service.SongService;
import com.example.spotifyplaylist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    private final SongService songService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, SongService songService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.songService = songService;
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
    public void addToPlaylist(Long id) {
        SongEntity songEntity = songService.findSongById(id);
        UserEntity userEntity = userRepository.findById(currentUser.getId()).orElse(null);
        if (userEntity != null && songEntity != null) {
            userEntity.getPlaylist().add(songEntity);
            userRepository.save(userEntity);
        }
    }

    @Override
    public void removeAllSongsFromThePlaylist() {
        UserEntity userEntity = userRepository.findById(currentUser.getId()).orElse(null);
        if (userEntity != null) {
            userEntity.getPlaylist().clear();
            userRepository.save(userEntity);
        }
    }

    @Override
    public List<SongViewModel> getCurrentUserPlaylist() {
        UserEntity userEntity = userRepository.findById(currentUser.getId()).orElse(null);

        return userEntity.getPlaylist()
                    .stream()
                    .map(songEntity -> modelMapper.map(songEntity, SongViewModel.class))
                    .collect(Collectors.toList());
    }
}
