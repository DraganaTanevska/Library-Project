package mk.ukim.finki.emt.lab2022.library.service;

import mk.ukim.finki.emt.lab2022.library.model.Author;
import mk.ukim.finki.emt.lab2022.library.model.Book;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(Long id);

    Book save(String name, Category category, Long author, int availableCopies);

    Book delete(Long id);

    Book edit(Long id, String name, Category category, Long author, int availableCopies);

    Book markAsTaken(Long id);

}
