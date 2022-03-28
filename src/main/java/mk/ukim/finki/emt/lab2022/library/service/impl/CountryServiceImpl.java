package mk.ukim.finki.emt.lab2022.library.service.impl;
import mk.ukim.finki.emt.lab2022.library.model.Country;
import mk.ukim.finki.emt.lab2022.library.repository.CountryRepository;
import mk.ukim.finki.emt.lab2022.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return null;
    }

    @Override
    public Country findById(Long id) {
        return null;
    }
}
