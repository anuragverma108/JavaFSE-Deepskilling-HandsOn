package com.example.countrydemo;

import com.example.countrydemo.model.Country;
import com.example.countrydemo.service.CountryService;
import com.example.countrydemo.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountrydemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountrydemoApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountrydemoApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        getCountryByCodeTest();
        testAddCountry();
    }

    private static void getCountryByCodeTest() {
        LOGGER.info("Start getCountryByCodeTest");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End getCountryByCodeTest");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("JP", "Japan");
        countryService.addCountry(newCountry);

        try {
            Country saved = countryService.findCountryByCode("JP");
            LOGGER.debug("Added Country: {}", saved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception after adding: {}", e.getMessage());
        }

        LOGGER.info("End testAddCountry");
    }
}
