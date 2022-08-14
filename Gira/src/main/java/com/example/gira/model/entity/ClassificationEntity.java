package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity{

    private ClassificationNameEnum name;
    private String description;

    public ClassificationEntity() {
    }

    public ClassificationEntity(ClassificationNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public ClassificationNameEnum getName() {
        return name;
    }

    public void setName(ClassificationNameEnum name) {
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
