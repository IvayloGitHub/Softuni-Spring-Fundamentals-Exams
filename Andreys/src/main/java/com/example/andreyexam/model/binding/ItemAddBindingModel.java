package com.example.andreyexam.model.binding;

import com.example.andreyexam.model.entity.enums.CategoryNameEnum;
import com.example.andreyexam.model.entity.enums.GenderEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private CategoryNameEnum category;
    private GenderEnum gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }


    @Size(min = 2, message = "Username length must be more than two characters")
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Size(min = 3, message = "Description length must be more than three characters")
    @NotBlank
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "You must select category!")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    @NotNull(message = "You must select gender!")
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Positive(message = "Price must be positive!")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
