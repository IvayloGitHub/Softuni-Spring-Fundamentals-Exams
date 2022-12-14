package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.CategoryEntity;
import com.example.coffeeshopexam.model.entity.enums.CategoryNameEnum;
import com.example.coffeeshopexam.repository.CategoryRepository;
import com.example.coffeeshopexam.service.CategoryService;
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
        if(categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        CategoryEntity category = new CategoryEntity();
                        category.setName(categoryNameEnum);
                        switch (categoryNameEnum) {
                            case DRINK: category.setNeededTime(1);
                                break;
                            case COFFEE: category.setNeededTime(2);
                                break;
                            case OTHER: category.setNeededTime(5);
                                break;
                            case CAKE: category.setNeededTime(10);
                            break;

                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity findCategoryByNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum)
                .orElse(null);
    }
}
