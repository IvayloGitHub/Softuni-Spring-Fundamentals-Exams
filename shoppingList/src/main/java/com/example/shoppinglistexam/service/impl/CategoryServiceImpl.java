package com.example.shoppinglistexam.service.impl;

import com.example.shoppinglistexam.model.entity.CategoryEntity;
import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistexam.repository.CategoryRepository;
import com.example.shoppinglistexam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        categoryRepository.save(new CategoryEntity(categoryNameEnum,
                                "Description for " + categoryNameEnum.name()));
                    });
        }
    }

    @Override
    public CategoryEntity findCategoryByName(CategoryNameEnum name) {
        return categoryRepository.findByName(name)
                .orElse(null);
    }
}
