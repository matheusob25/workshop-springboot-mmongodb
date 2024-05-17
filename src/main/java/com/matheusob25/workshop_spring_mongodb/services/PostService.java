package com.matheusob25.workshop_spring_mongodb.services;

import com.matheusob25.workshop_spring_mongodb.domain.Post;
import com.matheusob25.workshop_spring_mongodb.repository.PostRepository;
import com.matheusob25.workshop_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
    }
}
