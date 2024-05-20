package com.matheusob25.workshop_spring_mongodb.services;

import com.matheusob25.workshop_spring_mongodb.domain.Post;
import com.matheusob25.workshop_spring_mongodb.repository.PostRepository;
import com.matheusob25.workshop_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found with id " + id));
    }

    public List<Post> findAll() {
        return postRepository.findAll();

    }
    public List<Post> findByTitleContaining(String title) {
        return postRepository.findByTitle(title);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
