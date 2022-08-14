package com.example.spotifyplaylist.repository;

import com.example.spotifyplaylist.model.entity.StyleEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, Long> {

    Optional<StyleEntity> findByName(StyleNameEnum name);
}
