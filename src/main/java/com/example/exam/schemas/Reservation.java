package com.example.exam.schemas;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    public UUID id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private UUID bookId;
    private String reservedBy;


    public Reservation(LocalDateTime reservationStart, LocalDateTime reservationEnd, UUID bookId, String reservedBy) {
        this.id = UUID.randomUUID();
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.bookId = bookId;
        this.reservedBy = reservedBy;
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDateTime getReservationStart() {
        return this.reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return this.reservationEnd;
    }

    public UUID getBookId() {
        return this.bookId;
    }

    public String getReservedBy() {
        return this.reservedBy;
    }
}
