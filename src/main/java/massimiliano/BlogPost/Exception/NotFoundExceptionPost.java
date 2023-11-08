package massimiliano.BlogPost.Exception;

public class NotFoundExceptionPost extends RuntimeException {
    public NotFoundExceptionPost(int id) {
        super("Post:" + " " + id + " " + "NON trovato!!");
    }
}
