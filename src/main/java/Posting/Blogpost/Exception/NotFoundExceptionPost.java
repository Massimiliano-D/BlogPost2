package Posting.Blogpost.Exception;

public class NotFoundExceptionPost extends RuntimeException  {
    public NotFoundExceptionPost(int id){
        super("Post:" +" "+ id + " "+"NON trovato!!");
    }
}
