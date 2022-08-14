package com.example.spotifyplaylist.model.entity;

import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity{

    private StyleNameEnum name;
    private String description;

    public StyleEntity() {
    }

    public StyleEntity(StyleNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public StyleNameEnum getName() {
        return name;
    }

    public void setName(StyleNameEnum name) {
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
