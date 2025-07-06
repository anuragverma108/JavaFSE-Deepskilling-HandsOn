package com.example.hqldemo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.hqldemo.entity.Author;
import com.example.hqldemo.entity.Book;
import com.example.hqldemo.repository.AuthorRepository;
import com.example.hqldemo.repository.BookRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired AuthorRepository authorRepo;
    @Autowired BookRepository bookRepo;

    @Override
    public void run(String... args) {
        Author a1 = new Author();
        a1.setName("George Orwell");

        Author a2 = new Author();
        a2.setName("J.K. Rowling");

        Book b1 = new Book();
        b1.setTitle("1984");
        b1.setPrice(250.0);
        b1.setAuthor(a1);

        Book b2 = new Book();
        b2.setTitle("Animal Farm");
        b2.setPrice(180.0);
        b2.setAuthor(a1);

        Book b3 = new Book();
        b3.setTitle("Harry Potter");
        b3.setPrice(350.0);
        b3.setAuthor(a2);

        authorRepo.saveAll(List.of(a1, a2));
        bookRepo.saveAll(List.of(b1, b2, b3));
    }
}
