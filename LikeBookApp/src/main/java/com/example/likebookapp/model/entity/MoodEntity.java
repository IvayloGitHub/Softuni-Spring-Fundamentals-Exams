package com.example.likebookapp.model.entity;

import com.example.likebookapp.model.entity.enums.MoodNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class MoodEntity extends BaseEntity {

    private MoodNameEnum name;
    private String description;

    public MoodEntity() {
    }

    public MoodEntity(MoodNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public MoodNameEnum getName() {
        return name;
    }

    public void setName(MoodNameEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
