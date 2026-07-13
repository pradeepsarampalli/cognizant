package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.debug("Inside CountryController Constructor.");
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("END");
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START");
        LOGGER.debug("code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START");
        LOGGER.debug("country: {}", country);
        Country added = countryService.addCountry(country);
        LOGGER.info("END");
        return added;
    }
}
