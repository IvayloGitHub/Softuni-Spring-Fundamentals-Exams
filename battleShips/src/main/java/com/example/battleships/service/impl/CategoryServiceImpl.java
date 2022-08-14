package com.example.battleships.service.impl;

import com.example.battleships.model.entity.CategoryEntity;
import com.example.battleships.model.entity.enums.CategoryNameEnum;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.service.CategoryService;
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
    public CategoryEntity findCategoryByName(CategoryNameEnum category) {
        return categoryRepository.findByName(category)
                .orElse(null);
    }
}
