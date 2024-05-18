package com.matheusob25.workshop_spring_mongodb.config;

import com.matheusob25.workshop_spring_mongodb.domain.Post;
import com.matheusob25.workshop_spring_mongodb.domain.User;
import com.matheusob25.workshop_spring_mongodb.dto.AuthorDTO;
import com.matheusob25.workshop_spring_mongodb.dto.CommentDTO;
import com.matheusob25.workshop_spring_mongodb.repository.PostRepository;
import com.matheusob25.workshop_spring_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
   private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018",dtf),"Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018",dtf), "Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem amiga!",LocalDate.parse("21/03/2018",dtf) ,new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!",LocalDate.parse("22/03/2018",dtf) ,new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!",LocalDate.parse("23/03/2018",dtf) ,new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
