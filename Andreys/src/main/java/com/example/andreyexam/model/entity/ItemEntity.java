package com.example.andreyexam.model.entity;

import com.example.andreyexam.model.entity.enums.GenderEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class ItemEntity extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryEntity category;
    private GenderEnum gender;

    public ItemEntity() {
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

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(optional = false)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
