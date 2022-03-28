package mk.ukim.finki.emt.lab2022.library.service;

import mk.ukim.finki.emt.lab2022.library.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> listAll();
    Country findById(Long id);
}
