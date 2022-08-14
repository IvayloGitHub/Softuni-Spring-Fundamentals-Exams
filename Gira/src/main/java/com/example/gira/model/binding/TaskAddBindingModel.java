package com.example.gira.model.binding;

import com.example.gira.model.entity.enums.ClassificationNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {

    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;

    public TaskAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @NotNull(message = "Classification cannot be null")
    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
    }
}
