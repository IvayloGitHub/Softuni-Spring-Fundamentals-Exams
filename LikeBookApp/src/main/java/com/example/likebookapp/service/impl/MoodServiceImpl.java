package com.example.likebookapp.service.impl;

import com.example.likebookapp.model.entity.MoodEntity;
import com.example.likebookapp.model.entity.enums.MoodNameEnum;
import com.example.likebookapp.repository.MoodRepository;
import com.example.likebookapp.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {
        if (moodRepository.count() == 0) {
            Arrays.stream(MoodNameEnum.values())
                    .forEach(moodNameEnum -> {
                        moodRepository.save(new MoodEntity(moodNameEnum,
                                "Description for " + moodNameEnum.name()));
                    });
        }
    }

    @Override
    public MoodEntity findMoodByName(MoodNameEnum name) {
        return moodRepository.findByName(name)
                .orElse(null);
    }
}
