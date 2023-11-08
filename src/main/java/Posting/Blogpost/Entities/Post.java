package Posting.Blogpost.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Post {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private int tempoDiLettura;
    private String contenuto;
}
