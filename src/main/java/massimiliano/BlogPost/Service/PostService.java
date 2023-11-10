package massimiliano.BlogPost.Service;

import massimiliano.BlogPost.Entities.Post;
import massimiliano.BlogPost.Exception.NotFoundExceptionPost;
import massimiliano.BlogPost.Payloads.PostDTO;
import massimiliano.BlogPost.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(PostDTO body) {
        Post newPost = new Post();
        if (body.cover().equals("")) {
            newPost.setCover("https://picsum.photos/200/300");
        } else {
            newPost.setCover(body.cover());
        }
        newPost.setTitolo(body.titolo());
        newPost.setContenuto(body.contenuto());
        return postRepository.save(newPost);
    }

    public Page<Post> getPost(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return postRepository.findAll(pageable);
    }

    public Post findById(int id) {

        return postRepository.findById(id).orElseThrow(() -> new NotFoundExceptionPost(id));

    }

    public Post findAndUpdateById(int id, Post body) {
        Post found1 = this.findById(id);

        found1.setId(id);
        found1.setCategoria(body.getCategoria());
        found1.setTitolo(body.getTitolo());
        found1.setTempoDiLettura(body.getTempoDiLettura());
        found1.setContenuto(body.getContenuto());
        return found1;

    }


    public void findAndDeleteById(int id) {
        Post found1 = this.findById(id);
        postRepository.delete(found1);
    }
}