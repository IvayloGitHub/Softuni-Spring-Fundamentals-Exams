package com.example.likebookapp.model.binding;

import com.example.likebookapp.model.entity.enums.MoodNameEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostAddBindingModel {

    private String content;
    private MoodNameEnum mood;

    public PostAddBindingModel() {
    }

    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    @NotBlank
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotNull(message = "You must select a mood!")
    public MoodNameEnum getMood() {
        return mood;
    }

    public void setMood(MoodNameEnum mood) {
        this.mood = mood;
    }
}
