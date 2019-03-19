package com.learning.java.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.java.demo.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
