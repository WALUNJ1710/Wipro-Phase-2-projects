package com.libmanagement.bookservice.repository;

import com.libmanagement.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository provides findAll(), save(), deleteById(), etc.
}
