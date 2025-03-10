package com.libmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.libmanagement.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}