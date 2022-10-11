package com.example.likebookapp.repository;

import com.example.likebookapp.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Set<PostEntity> findByUser_Id(Long user_id);
    Set<PostEntity> findByUser_IdNot(Long user_id);
}
