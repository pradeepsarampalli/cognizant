package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryDao countryDao;

    @Transactional
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        List<Country> countries = countryDao.getAllCountries();
        LOGGER.info("END");
        return countries;
    }

    @Transactional
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START");
        LOGGER.debug("code: {}", code);

        Country country = countryDao.getAllCountries().stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);

        LOGGER.info("END");
        return country;
    }

    @Transactional
    public Country addCountry(Country country) {
        LOGGER.info("START");
        countryDao.addCountry(country);
        LOGGER.info("END");
        return country;
    }
}
