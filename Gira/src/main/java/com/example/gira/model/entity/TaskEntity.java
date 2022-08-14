package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {

    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationEntity classification;
    private UserEntity user;

    public TaskEntity() {
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    @Column(nullable = false)
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @ManyToOne(optional = false)
    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }

    @ManyToOne(optional = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
