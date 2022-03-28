package mk.ukim.finki.emt.lab2022.library.service;

import mk.ukim.finki.emt.lab2022.library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAll();
    Author findById(Long id);
}
