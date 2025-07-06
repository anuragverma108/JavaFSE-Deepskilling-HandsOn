package com.example.hqldemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hqldemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findByTitle(String title);
    @Query("SELECT b FROM Book b JOIN FETCH b.author")
    List<Book> findAllWithAuthor();
    @Query("SELECT MAX(b.price) FROM Book b")
    Double findMaxPrice();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.author.name = ?1")
    Long countBooksByAuthor(String authorName);
    @Query(value = "SELECT * FROM book WHERE price > ?1", nativeQuery = true)
    List<Book> findBooksByPriceGreaterThan(double price);
}
