package com.example.gira.model.service;

import com.example.gira.model.entity.enums.ClassificationNameEnum;
import com.example.gira.model.entity.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
    }
}
