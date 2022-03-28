package mk.ukim.finki.emt.lab2022.library.service.impl;
import mk.ukim.finki.emt.lab2022.library.model.Author;
import mk.ukim.finki.emt.lab2022.library.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab2022.library.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2022.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }
}
