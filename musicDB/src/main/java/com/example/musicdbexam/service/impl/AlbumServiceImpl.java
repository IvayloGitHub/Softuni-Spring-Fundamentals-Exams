package com.example.musicdbexam.service.impl;

import com.example.musicdbexam.model.entity.AlbumEntity;
import com.example.musicdbexam.model.service.AlbumServiceModel;
import com.example.musicdbexam.model.view.AlbumViewModel;
import com.example.musicdbexam.repository.AlbumRepository;
import com.example.musicdbexam.sec.CurrentUser;
import com.example.musicdbexam.service.AlbumService;
import com.example.musicdbexam.service.ArtistService;
import com.example.musicdbexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        AlbumEntity albumEntity = modelMapper.map(albumServiceModel, AlbumEntity.class);
        albumEntity.setArtist(artistService.findArtistByName(albumServiceModel.getArtist()));
        albumEntity.setAddedFrom(userService.findUserById(currentUser.getId()));
        albumRepository.save(albumEntity);
    }

    @Override
    public List<AlbumViewModel> getAllAlbumsOrderedByCopiesDesc() {
        return albumRepository.findAllByOrderByCopiesDesc()
                .stream()
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = modelMapper.map(albumEntity, AlbumViewModel.class);
                    albumViewModel.setArtist(albumEntity.getArtist().getName());
                    return albumViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Integer totalSoldCopies() {
        if(albumRepository.findTotalSoldCopies() == null) {
            return 0;
        }
        return albumRepository.findTotalSoldCopies();
    }
}
