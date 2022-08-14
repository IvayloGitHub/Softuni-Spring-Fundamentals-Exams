package com.example.spotifyplaylist.service.impl;

import com.example.spotifyplaylist.model.entity.StyleEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylist.repository.StyleRepository;
import com.example.spotifyplaylist.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {
    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if (styleRepository.count() == 0) {
            Arrays.stream(StyleNameEnum.values())
                    .forEach(styleNameEnum -> styleRepository.save(new StyleEntity(styleNameEnum,
                            "Description for " + styleNameEnum.name())));
        }
    }

    @Override
    public StyleEntity findStyleEntityByName(StyleNameEnum name) {
        return styleRepository.findByName(name)
                .orElse(null);
    }
}
