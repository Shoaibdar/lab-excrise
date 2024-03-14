package com.lab.exercise.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.exercise.entities.Post;
import com.lab.exercise.repositories.PostRepository;

@RestController
@RequestMapping("/api/users")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // GET /api/users
    @GetMapping
    public List<Post> getAllUsers() {
        return postRepository.findAll();
    }

    // GET /api/users/{user}
    @GetMapping("/{user}")
    public List<Post> getUserPosts(@PathVariable String user) {
        return postRepository.findAllByEmail(user);
    }

    // GET /api/users/{user}/posts/all
    @GetMapping("/{user}/posts/all")
    public List<Post> getAllUserPosts(@PathVariable String user) {
        return postRepository.findAllByEmail(user);
    }

    // GET /api/users/{user}/posts/{id}
    @GetMapping("/{user}/posts/{id}")
    public ResponseEntity<List<Post>> getUserPostById(@PathVariable String user, @PathVariable Long id) {
        List<Post> post = postRepository.findByIdAndEmail(id, user);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/users/{user}/posts
    @PostMapping("/{user}/posts")
    public ResponseEntity<Post> createPost(@PathVariable String user, @RequestBody Post post) {
        post.setEmail(user);
        Post savedPost = postRepository.save(post);
        return ResponseEntity.created(URI.create("/api/users/" + user + "/posts/" + savedPost.getId())).body(savedPost);
    }

    // PUT /api/users/{user}/{id}
    @PutMapping("/{user}/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String user, @PathVariable Long id, @RequestBody Post post) {
        if (!postRepository.existsByIdAndEmail(id, user)) {
            return ResponseEntity.notFound().build();
        }
        post.setId(id);
        post.setEmail(user);
        Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }

    // DELETE /api/users/{user}/{id}
    @DeleteMapping("/{user}/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String user, @PathVariable Long id) {
        if (!postRepository.existsByIdAndEmail(id, user)) {
            return ResponseEntity.notFound().build();
        }
        postRepository.deleteByIdAndEmail(id, user);
        return ResponseEntity.noContent().build();
    }
}
