package com.example.battleships.model.entity;

import com.example.battleships.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    private CategoryNameEnum name;
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
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
