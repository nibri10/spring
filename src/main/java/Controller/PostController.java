package Controller;

import Entity.Post;
import Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/")
    public String name() {
        return "ok";
    }
    @PostMapping("/add-post")
    public Post addProduct(@RequestBody Post post){
        return service.save(post);
    }

    @PostMapping("/add-posts")
    public List<Post> addPosts(@RequestBody List<Post> posts){
        return service.saveAll(posts);
    }

    @GetMapping("/posts")
    public List<Post> getAllProducts(){
        return service.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public Post findPostById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/posts/{title}")
    public Post findPostByTitle(@PathVariable String title){
        return service.getByTitle(title);
    }
    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable Long id){
        service.deleteById(id);
        return "ok" + id;
    }
}
