package com.example.andreyexam.service;

import com.example.andreyexam.model.entity.CategoryEntity;
import com.example.andreyexam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findCategoryByName(CategoryNameEnum category);
}
