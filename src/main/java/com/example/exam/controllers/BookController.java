package com.example.exam.controllers;

import com.example.exam.schemas.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.exam.services.BookService;

import java.time.LocalDateTime;
import java.util.ArrayList;

class CreateBookBody {

    public String authorId;
    public String title;
    public String language;
    public String publishedAt;
    public String isbn;

    public CreateBookBody() {
    }
    public String getAuthorId() { return this.authorId; }

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

class UpdateBookBody {

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
            bookService.create(book.getTitle(), book.getLanguage(), book.getPublishedAt(), book.getIsbn());

            return ResponseEntity.ok("A new book was created!");
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
