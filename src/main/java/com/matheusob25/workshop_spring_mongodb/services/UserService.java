package com.matheusob25.workshop_spring_mongodb.services;

import com.matheusob25.workshop_spring_mongodb.domain.User;
import com.matheusob25.workshop_spring_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
