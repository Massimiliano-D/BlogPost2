package Posting.Blogpost.Service;

import Posting.Blogpost.Entities.Utente;
import Posting.Blogpost.Exception.NotFoundExceptionUtente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class UtenteService {
    private List<Utente> utente = new ArrayList<>();

    public Utente save(Utente body) {
        Random rdm = new Random();
        body.setId(rdm.nextInt(1, 1000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        this.utente.add(body);
        return body;
    }

    public List<Utente> getUtente() {

        return this.utente;
    }

    public Utente findById(int id) {
        Utente ute = null;
        for (Utente utente : this.utente) {
            if (utente.getId() == id) {
                ute = utente;
            }
        }
        if (ute == null) {
            throw new NotFoundExceptionUtente(id);
        } else {
            return ute;
        }
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Utente> iterator = this.utente.listIterator();

        while (iterator.hasNext()) {
            Utente current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Utente findByIdAndUpdate(int id, Utente body) {
        Utente found = null;

        for (Utente utente : this.utente) {
            if (utente.getId() == id) {
                found = utente;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
            }
        }
        if (found == null) {
            throw new NotFoundExceptionUtente(id);
        } else {
            return found;
        }
    }
}
