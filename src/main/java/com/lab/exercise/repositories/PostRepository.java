package com.lab.exercise.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.exercise.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByEmail(String email);
    
    // Custom query method to find post by id and email
    List<Post> findByIdAndEmail(Long id, String email);
    
    // Check if a post exists by id and email
    boolean existsByIdAndEmail(Long id, String email);
    
    // Delete a post by id and email
    void deleteByIdAndEmail(Long id, String email);
}
