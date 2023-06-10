package com.example.exam.controllers;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

class CreateReservationBody {
    private String createdAt;
    private String reservationStart;
    private String reservationEnd;
    private String personName;
    private Integer bookId;

    public CreateReservationBody() {}

    private String getDateOfCreation {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getDate() {
        return this.date;
    }

    public Integer getRoomId() {
        return this.roomId;
    }

    public String getPersonName() {
        return this.personName;
    }
}

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
}
