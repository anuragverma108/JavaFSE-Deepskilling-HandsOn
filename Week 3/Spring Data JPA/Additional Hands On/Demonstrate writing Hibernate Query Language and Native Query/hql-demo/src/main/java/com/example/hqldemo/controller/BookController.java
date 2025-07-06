package com.example.hqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hqldemo.entity.Book;
import com.example.hqldemo.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired private BookRepository repo;

    @GetMapping("/title")
    public List<Book> getByTitle(@RequestParam String title) {
        return repo.findByTitle(title);
    }

    @GetMapping("/with-authors")
    public List<Book> getAllWithAuthors() {
        return repo.findAllWithAuthor();
    }

    @GetMapping("/max-price")
    public Double getMaxPrice() {
        return repo.findMaxPrice();
    }

    @GetMapping("/count-by-author")
    public Long countByAuthor(@RequestParam String name) {
        return repo.countBooksByAuthor(name);
    }

    @GetMapping("/expensive")
    public List<Book> getExpensiveBooks(@RequestParam double price) {
        return repo.findBooksByPriceGreaterThan(price);
    }
}
