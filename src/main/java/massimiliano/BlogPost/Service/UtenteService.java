package massimiliano.BlogPost.Service;

import massimiliano.BlogPost.Entities.Utente;
import massimiliano.BlogPost.Exception.BadRequestException;
import massimiliano.BlogPost.Exception.NotFoundExceptionUtente;
import massimiliano.BlogPost.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ListIterator;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente body) {


        utenteRepository.findByEmail(body.getEmail()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già utilizzata!");
        });

        body.setAvatar("http://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());

        return utenteRepository.save(body);
    }

    public Page<Utente> getUtente(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));

        return utenteRepository.findAll(pageable);
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
