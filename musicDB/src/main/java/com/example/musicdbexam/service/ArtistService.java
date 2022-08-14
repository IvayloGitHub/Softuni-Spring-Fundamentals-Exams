package com.example.musicdbexam.service;

import com.example.musicdbexam.model.entity.ArtistEntity;
import com.example.musicdbexam.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();


    ArtistEntity findArtistByName(ArtistNameEnum artist);
}
