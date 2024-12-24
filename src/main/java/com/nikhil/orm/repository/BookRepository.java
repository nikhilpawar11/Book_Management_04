package com.nikhil.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.orm.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
