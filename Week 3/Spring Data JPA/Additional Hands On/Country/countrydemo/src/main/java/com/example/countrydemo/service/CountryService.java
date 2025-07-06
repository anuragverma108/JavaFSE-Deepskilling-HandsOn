package com.example.countrydemo.service;

import com.example.countrydemo.model.Country;
import com.example.countrydemo.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryByCode(String code);
    
    @Transactional
    Country addCountry(Country country);
    
    Country updateCountry(Country country);
    void deleteCountry(String code);
    List<Country> searchCountriesByName(String partialName);

    @Transactional
    Country findCountryByCode(String countryCode) throws CountryNotFoundException;
}
