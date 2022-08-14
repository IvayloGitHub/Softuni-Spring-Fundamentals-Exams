package com.example.spotifyplaylist.service.impl;

import com.example.spotifyplaylist.model.entity.SongEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylist.model.service.SongServiceModel;
import com.example.spotifyplaylist.model.view.SongViewModel;
import com.example.spotifyplaylist.repository.SongRepository;
import com.example.spotifyplaylist.service.SongService;
import com.example.spotifyplaylist.service.StyleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ModelMapper modelMapper;

    private final StyleService styleService;

    public SongServiceImpl(SongRepository songRepository, ModelMapper modelMapper, StyleService styleService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
    }

    @Override
    public void addSong(SongServiceModel songServiceModel) {
        SongEntity songEntity = modelMapper.map(songServiceModel, SongEntity.class);
        songEntity.setStyle(styleService.findStyleEntityByName(songServiceModel.getStyle()));
        songRepository.save(songEntity);
    }

    @Override
    public List<SongViewModel> findAllSongsByStyleName(StyleNameEnum name) {
        return songRepository.findAllByStyle_Name(name)
                .stream()
                .map(songEntity -> modelMapper.map(songEntity, SongViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public SongEntity findSongById(Long id) {
        return songRepository.findById(id)
                .orElse(null);
    }
}
