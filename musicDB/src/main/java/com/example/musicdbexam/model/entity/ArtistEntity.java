package com.example.musicdbexam.model.entity;

import com.example.musicdbexam.model.entity.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity{

    private ArtistNameEnum name;
    private String careerInformation;


    public ArtistEntity() {
    }

    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }
    @Column(columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
