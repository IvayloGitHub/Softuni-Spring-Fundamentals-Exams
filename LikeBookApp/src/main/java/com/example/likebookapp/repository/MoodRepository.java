package com.example.likebookapp.repository;

import com.example.likebookapp.model.entity.MoodEntity;
import com.example.likebookapp.model.entity.enums.MoodNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<MoodEntity, Long> {

    Optional<MoodEntity> findByName(MoodNameEnum name);
}
