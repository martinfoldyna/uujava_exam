package com.example.exam.schemas;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    public UUID id;
    private String reservationStart;
    private String reservationEnd;
    private Integer bookId;
    private String reservedBy;


    public ReservationController(String title, String countryOrigin, String language, LocalDate publishedAt, String isbn) {
        this.id = UUID.randomUUID();
        this.title = title;
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
