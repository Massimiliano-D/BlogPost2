package Posting.Blogpost.Service;

import Posting.Blogpost.Entities.Post;

import Posting.Blogpost.Exception.NotFoundExceptionPost;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
@Service
public class PostService {
    private List<Post> post = new ArrayList<>();

    public Post save(Post body){
        Random rdm = new Random();
        body.setId(rdm.nextInt(1, 1000));
        body.setCover("https://picsum.photos/200/300");
        this.post.add(body);
        return body;
    }

    public List<Post> getPost() {
        return this.post;
    }

    public Post findById(int id){
        Post pos = null;
        for (Post post: this.post) {
            if (post.getId() == id) {
                pos = post;
            }
        }
        if(pos == null ){
            throw new NotFoundExceptionPost(id);
        } else {
            return pos;
        }
    }

    public void findByIdAndDelete(int id){
        ListIterator<Post> iterator = this.post.listIterator();

        while (iterator.hasNext()){
            Post current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }

    public Post findByIdAndUpdate(int id, Post body){
        Post found1 = null;

        for (Post post:this.post) {
            if(post.getId() == id){
                found1 = post;
                found1.setId(id);
                found1.setCategoria(body.getCategoria());
                found1.setTitolo(body.getTitolo());
                found1.setTempoDiLettura(body.getTempoDiLettura());
                found1.setContenuto(body.getContenuto());
            }
        }
        if(found1 == null ){
            throw new NotFoundExceptionPost(id);
        } else {
            return found1;
        }
    }
}
