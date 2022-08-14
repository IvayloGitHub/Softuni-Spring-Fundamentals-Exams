package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.entity.CategoryEntity;
import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findCategoryByName(CategoryNameEnum category);
}
