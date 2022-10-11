package com.example.likebookapp.model.service;

import com.example.likebookapp.model.entity.enums.MoodNameEnum;

public class PostServiceModel {

    private Long id;
    private String content;
    private MoodNameEnum mood;

    public PostServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodNameEnum getMood() {
        return mood;
    }

    public void setMood(MoodNameEnum mood) {
        this.mood = mood;
    }
}
