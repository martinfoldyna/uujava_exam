package com.example.exam.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.exam.services.BookService;

import java.time.LocalDateTime;
import java.util.ArrayList;

class CreateBookBody {
    // TODO: Add author
    public String title;
    public String language;
    public String publishedAt;
    public String isbn;

    public CreateBookBody() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public String getIsbn() {
        return this.isbn;
    }
}

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<String> createBook(@RequestBody CreateBookBody book) {
        try {
            bookService.create(reservation.getDate(), reservation.getReservedBy(), reservation.getRoomId());

            return ResponseEntity.ok("A new reservation was created!");
        } catch (Exception e) {
            System.out.println(e);

            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }
}
