package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistexam.model.service.ProductServiceModel;
import com.example.shoppinglistexam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum drink);

    void buyById(Long id);

    void buyAll();

    BigDecimal findTotalSumOfProducts();
}
