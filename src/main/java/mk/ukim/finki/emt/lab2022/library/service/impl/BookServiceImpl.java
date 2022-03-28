package mk.ukim.finki.emt.lab2022.library.service.impl;
import mk.ukim.finki.emt.lab2022.library.model.Author;
import mk.ukim.finki.emt.lab2022.library.model.Book;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;
import mk.ukim.finki.emt.lab2022.library.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab2022.library.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.lab2022.library.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2022.library.repository.BookRepository;
import mk.ukim.finki.emt.lab2022.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
    }

    @Override
    public Book save(String name, Category category, Long author, int availableCopies) {
        Author author1=authorRepository.findById(author).orElseThrow(()-> new AuthorNotFoundException(author));
        Book book=new Book(name,category,author1,availableCopies);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        Book book=this.findById(id);
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book edit(Long id, String name, Category category, Long author, int availableCopies) {
        Author author1=authorRepository.findById(author).orElseThrow(()-> new AuthorNotFoundException(author));
        Book book=this.findById(id);
        book.setAuthor(author1);
        book.setCategory(category);
        book.setName(name);
        book.setAvailableCopies(availableCopies);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book=this.findById(id);
        int availableCopies=book.getAvailableCopies()-1;
        book.setAvailableCopies(availableCopies);
        bookRepository.save(book);
        return book;
    }
}
