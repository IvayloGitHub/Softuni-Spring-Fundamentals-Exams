package com.example.battleships.repository;

import com.example.battleships.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {


    List<ShipEntity> findAllByOrderById();
    List<ShipEntity> findAllByUser_Id(Long user_id);
    List<ShipEntity> findAllByUser_IdNot(Long user_id);
}
