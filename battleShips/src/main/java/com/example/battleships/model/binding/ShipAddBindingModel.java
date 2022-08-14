package com.example.battleships.model.binding;

import com.example.battleships.model.entity.CategoryEntity;
import com.example.battleships.model.entity.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {

    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    @NotBlank
    @Size(min = 2, max = 10, message = "The name must be between 2 and 10 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Positive(message = "The health must be positive.")
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @NotNull
    @Positive(message = "The power must be positive.")
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @NotNull
    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull(message = "You must select the category.")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
