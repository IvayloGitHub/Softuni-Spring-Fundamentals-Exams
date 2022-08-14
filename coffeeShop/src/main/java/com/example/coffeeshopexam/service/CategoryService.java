package com.example.coffeeshopexam.service;

import com.example.coffeeshopexam.model.entity.CategoryEntity;
import com.example.coffeeshopexam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    CategoryEntity findCategoryByNameEnum(CategoryNameEnum categoryNameEnum);

}
