package com.matheusob25.workshop_spring_mongodb.repository;

import com.matheusob25.workshop_spring_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {



}

