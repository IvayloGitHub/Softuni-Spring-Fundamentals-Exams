package com.example.coffeeshopexam.repository;

import com.example.coffeeshopexam.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByOrderByPriceDesc();

    @Query("SELECT SUM(o.category.neededTime) FROM OrderEntity AS o")
    Integer findTotalTimeForAllOrders();
}
