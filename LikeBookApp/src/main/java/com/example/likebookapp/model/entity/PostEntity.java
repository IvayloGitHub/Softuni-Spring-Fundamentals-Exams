package com.example.likebookapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {

    private String content;
    private UserEntity user;
    private Set<UserEntity> userLikes;
    private MoodEntity mood;

    public PostEntity() {
    }

    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<UserEntity> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserEntity> userLikes) {
        this.userLikes = userLikes;
    }

    @ManyToOne
    public MoodEntity getMood() {
        return mood;
    }

    public void setMood(MoodEntity mood) {
        this.mood = mood;
    }
}
