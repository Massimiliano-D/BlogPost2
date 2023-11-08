package Posting.Blogpost.Controller;

import Posting.Blogpost.Entities.Post;
import Posting.Blogpost.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getPost(){
        return postService.getPost();
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201 codice che decidi tu
    public Post savePost(@RequestBody Post body){
        return postService.save(body);
    }
    @GetMapping("/{id}")
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }
    @PutMapping ("/{id}")
    public Post findByIdAndUpdate (@PathVariable int id ,@RequestBody Post body){
        return postService.findByIdAndUpdate(id, body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id){
        postService.findByIdAndDelete(id);
    }
}
