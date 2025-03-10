package com.libmanagement.bookservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.libmanagement.bookservice.model.Book;
import com.libmanagement.bookservice.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Book borrowBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            bookRepository.save(book);
            
            // Send Kafka event
            kafkaTemplate.send("borrow-events", "Book borrowed: " + book.getTitle());
        }
        return book;
    }
    
    public Book returnBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            bookRepository.save(book);
            
            // Send Kafka event
            kafkaTemplate.send("return-events", "Book returned: " + book.getTitle());
        }
        return book;
    }
}