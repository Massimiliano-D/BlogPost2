package Posting.Blogpost.Exception;

public class NotFoundExceptionUtente extends RuntimeException {
    public NotFoundExceptionUtente(int id){
        super("Utente:" +" "+ id + " "+"NON trovato!!");
    }
}
