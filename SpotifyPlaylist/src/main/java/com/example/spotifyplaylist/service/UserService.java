package com.example.spotifyplaylist.service;

import com.example.spotifyplaylist.model.service.UserServiceModel;
import com.example.spotifyplaylist.model.view.SongViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    void loginUser(Long id, String username);

    void addToPlaylist(Long id);

    void removeAllSongsFromThePlaylist();

    List<SongViewModel> getCurrentUserPlaylist();
}
