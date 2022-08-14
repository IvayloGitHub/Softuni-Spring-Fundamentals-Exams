package com.example.spotifyplaylist.repository;

import com.example.spotifyplaylist.model.entity.SongEntity;
import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

    List<SongEntity> findAllByStyle_Name(StyleNameEnum name);

}
