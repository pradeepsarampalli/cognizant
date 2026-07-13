package com.cognizant.springlearn.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);

    @SuppressWarnings("unchecked")
    private static final List<Country> COUNTRY_LIST;

    static {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        COUNTRY_LIST = (List<Country>) context.getBean("countryList", List.class);
        LOGGER.info("END");
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START");
        LOGGER.debug("countries: {}", COUNTRY_LIST);
        LOGGER.info("END");
        return COUNTRY_LIST;
    }

    public void addCountry(Country country) {
        LOGGER.info("START");
        COUNTRY_LIST.add(country);
        LOGGER.info("END");
    }
}
