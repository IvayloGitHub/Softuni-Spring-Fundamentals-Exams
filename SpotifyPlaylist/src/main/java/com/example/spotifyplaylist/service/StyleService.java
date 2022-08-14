package com.example.spotifyplaylist.service;

import com.example.spotifyplaylist.model.entity.StyleEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;

public interface StyleService {
    void initStyles();

    StyleEntity findStyleEntityByName(StyleNameEnum style);
}
