package com.example.exam.schemas;

import java.time.LocalDate;
import java.util.UUID;

public class Book {
    public UUID id;

    // TODO: Add author
    public String title;
    public String language;
    public LocalDate publishedAt;
    public String countryOrigin;
    public String isbn;

    public Book(String name, String countryOrigin, String language, LocalDate publishedAt, String isbn) {
        this.id = UUID.randomUUID();
        this.title = name;
        this.language = language;
        this.countryOrigin = countryOrigin;
        this.publishedAt = publishedAt;
        this.isbn = isbn;
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDate getPublishedAt() {
        return this.publishedAt;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountryOrigin() {
        return this.countryOrigin;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }
}
