package com.example.musicdbexam.repository;

import com.example.musicdbexam.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    List<AlbumEntity> findAllByOrderByCopiesDesc();

    @Query("SELECT SUM(a.copies) FROM AlbumEntity AS a")
    Integer findTotalSoldCopies();
}
