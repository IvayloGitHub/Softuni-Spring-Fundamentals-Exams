package com.example.musicdbexam.repository;

import com.example.musicdbexam.model.entity.ArtistEntity;
import com.example.musicdbexam.model.entity.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    Optional<ArtistEntity> findByName(ArtistNameEnum name);
}
