package com.libmanagement.borrowservice.controller;

import com.libmanagement.borrowservice.model.Borrow;
import com.libmanagement.borrowservice.repository.BorrowRepository;
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
    public Borrow borrowBook(@RequestBody Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @GetMapping("/user/{userId}")
    public List<Borrow> getBorrowedBooks(@PathVariable Long userId) {
        return borrowRepository.findByUserId(userId);
    }
}
