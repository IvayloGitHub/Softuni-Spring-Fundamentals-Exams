package com.example.shoppinglistexam.repository;

import com.example.shoppinglistexam.model.entity.ProductEntity;
import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory_Name(CategoryNameEnum categoryName);

    @Query("SELECT SUM(p.price) FROM ProductEntity AS p")
    BigDecimal findTotalSumOfAllProducts();
}
