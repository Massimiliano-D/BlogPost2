package Posting.Blogpost.Entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Utente {
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    }
