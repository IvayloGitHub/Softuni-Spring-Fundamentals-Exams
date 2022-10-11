package com.example.likebookapp.service;

import com.example.likebookapp.model.entity.MoodEntity;
import com.example.likebookapp.model.entity.enums.MoodNameEnum;

public interface MoodService {
    void initMoods();

    MoodEntity findMoodByName(MoodNameEnum mood);
}
