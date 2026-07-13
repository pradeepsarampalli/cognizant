package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Hands on 6 - Find a country based on country code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found for code: " + countryCode);
        }
        return result.get();
    }

    // Hands on 7 - Add a new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Hands on 8 - Update a country based on code
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found for code: " + code);
        }
        Country country = result.get();
        country.setName(name);
        countryRepository.save(country);
    }

    // Hands on 9 - Delete a country based on code
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // Doc 2, Hands on 1 - Query Methods for search box / alphabet index
    @Transactional
    public List<Country> findCountriesContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional
    public List<Country> findCountriesContainingOrderByName(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional
    public List<Country> findCountriesStartingWith(String letter) {
        return countryRepository.findByNameStartingWithOrderByNameAsc(letter);
    }
}
