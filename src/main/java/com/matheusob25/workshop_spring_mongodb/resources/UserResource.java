package com.matheusob25.workshop_spring_mongodb.resources;

import com.matheusob25.workshop_spring_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1001", "Maria Brown", "maria@gmail.com");
        User alex = new User("1002", "Alex Green", "alex@gmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(users);
    }
}
