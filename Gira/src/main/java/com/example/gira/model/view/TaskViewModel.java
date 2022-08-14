package com.example.gira.model.view;

import com.example.gira.model.entity.enums.ClassificationNameEnum;
import com.example.gira.model.entity.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String username;
    private ClassificationNameEnum classification;
    private LocalDate dueDate;
    private ProgressEnum progress;

    public TaskViewModel() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }
}
