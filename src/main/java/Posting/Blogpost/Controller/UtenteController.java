package Posting.Blogpost.Controller;

import Posting.Blogpost.Entities.Utente;
import Posting.Blogpost.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping("")
    public List<Utente> getUtente() {

        return utenteService.getUtente();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201 codice che decidi tu
    public Utente saveUser(@RequestBody Utente body) {
        return utenteService.save(body);
    }

    @GetMapping("/{id}")
    public Utente findById(@PathVariable int id) {

        return utenteService.findById(id);
    }

    @PutMapping("/{id}")
    public Utente findByIdAndUpdate(@PathVariable int id, @RequestBody Utente body) {
        return utenteService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) {

        utenteService.findByIdAndDelete(id);
    }
}
