package com.example.spotifyplaylist.service;

import com.example.spotifyplaylist.model.entity.SongEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylist.model.service.SongServiceModel;
import com.example.spotifyplaylist.model.view.SongViewModel;

import java.util.List;

public interface SongService {
    void addSong(SongServiceModel songServiceModel);

    List<SongViewModel> findAllSongsByStyleName(StyleNameEnum name);

    SongEntity findSongById(Long id);
}
