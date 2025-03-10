package com.libmanagement.borrowservice.controller;

import com.libmanagement.borrowservice.model.Borrow;
import com.libmanagement.borrowservice.repository.BorrowRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final BorrowRepository borrowRepository;

    public BorrowController(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @PostMapping
    public ResponseEntity<Borrow> borrowBook(@RequestBody Borrow borrow) {
        Borrow savedBorrow = borrowRepository.save(borrow);
        return ResponseEntity.ok(savedBorrow);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Borrow>> getBorrowedBooks(@PathVariable Long userId) {
        List<Borrow> borrows = borrowRepository.findByUserId(userId);
        return ResponseEntity.ok(borrows);
    }
}
