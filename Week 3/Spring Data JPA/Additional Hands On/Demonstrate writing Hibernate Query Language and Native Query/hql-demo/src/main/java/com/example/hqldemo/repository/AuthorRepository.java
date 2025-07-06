package com.example.hqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hqldemo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
