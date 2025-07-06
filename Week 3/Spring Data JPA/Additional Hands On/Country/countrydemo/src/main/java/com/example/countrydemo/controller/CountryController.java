package com.example.countrydemo.controller;

import com.example.countrydemo.model.Country;
import com.example.countrydemo.service.CountryService;
import com.example.countrydemo.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code);
    }

    @GetMapping("/find/{code}")
    public Country findByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> searchByName(@RequestParam String name) {
        return countryService.searchCountriesByName(name);
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
}
