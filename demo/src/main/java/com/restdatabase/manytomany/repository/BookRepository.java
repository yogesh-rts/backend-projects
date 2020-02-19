package com.restdatabase.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restdatabase.manytomany.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}

