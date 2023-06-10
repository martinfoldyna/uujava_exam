package com.example.exam.schemas;

import java.time.LocalDateTime;
import java.util.UUID;

public class Book {
    public UUID id;

    // TODO: Add author
    public String title;
    public String language;
    public LocalDateTime publishedAt;
    public String isbn;

    public Book(String title, String countryOrigin, String language, LocalDateTime publishedAt, String isbn) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.language = language;
        this.publishedAt = publishedAt;
        this.isbn = isbn;
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDateTime getPublishedAt() {
        return this.publishedAt;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }
}
