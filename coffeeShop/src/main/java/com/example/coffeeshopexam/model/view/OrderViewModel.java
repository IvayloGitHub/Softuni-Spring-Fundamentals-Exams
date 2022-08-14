package com.example.coffeeshopexam.model.view;

import com.example.coffeeshopexam.model.entity.CategoryEntity;

import java.math.BigDecimal;


public class OrderViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;
    private String image;

    public OrderViewModel() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
