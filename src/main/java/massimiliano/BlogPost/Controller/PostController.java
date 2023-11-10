package massimiliano.BlogPost.Controller;

import massimiliano.BlogPost.Entities.Post;
import massimiliano.BlogPost.Payloads.PostDTO;
import massimiliano.BlogPost.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public Page<Post> getPost(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "id") String orderBy) {
        return postService.getPost(page, size, orderBy);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201 codice che decidi tu
    public Post savePost(@RequestBody PostDTO body) {
        return postService.save(body);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable int id) {
        return postService.findById(id);
    }


    @PutMapping("/{id}")
    public Post findAndUpdateById(@PathVariable int id, @RequestBody Post body) {
        return postService.findAndUpdateById(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDeleteById(@PathVariable int id) {
        postService.findAndDeleteById(id);
    }
}
