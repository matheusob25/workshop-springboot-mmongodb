package com.matheusob25.workshop_spring_mongodb.resources;

import com.matheusob25.workshop_spring_mongodb.domain.Post;
import com.matheusob25.workshop_spring_mongodb.resources.util.URL;
import com.matheusob25.workshop_spring_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
       Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title){
        title = URL.decodeParams(title.trim());
        List<Post> posts = postService.findByTitleContaining(title);
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/fullsearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String title,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate )
    {
        title = URL.decodeParams(title.trim());
        List<Post> posts = postService.fullSearch(title, URL.convertDate(minDate, LocalDate.now().minusYears(3000)), URL.convertDate(maxDate, LocalDate.now()));
        return ResponseEntity.ok().body(posts);
    }

}
