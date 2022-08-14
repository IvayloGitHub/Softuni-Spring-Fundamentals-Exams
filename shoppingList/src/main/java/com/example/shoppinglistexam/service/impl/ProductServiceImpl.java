package com.example.shoppinglistexam.service.impl;

import com.example.shoppinglistexam.model.entity.ProductEntity;
import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistexam.model.service.ProductServiceModel;
import com.example.shoppinglistexam.model.view.ProductViewModel;
import com.example.shoppinglistexam.repository.ProductRepository;
import com.example.shoppinglistexam.service.CategoryService;
import com.example.shoppinglistexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        productEntity.setCategory(categoryService.findCategoryByName(productServiceModel.getCategory()));
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }

    @Override
    public BigDecimal findTotalSumOfProducts() {
        if(productRepository.findTotalSumOfAllProducts() == null) {
            return BigDecimal.valueOf(0.0);
        }
        return productRepository.findTotalSumOfAllProducts();
    }
}
