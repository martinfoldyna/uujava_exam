package com.example.exam.controllers;

import com.example.exam.schemas.Book;
import com.example.exam.services.ReservationService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class CreateReservationBody {
    private String createdAt;
    private String reservationStart;
    private String reservationEnd;
    private String personName;
    private Integer bookId;

    public CreateReservationBody() {}
    private String getDateOfCreation {return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);}
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

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("")
    public ResponseEntity<String> createReservation(@RequestBody CreateReservationBody reservation) {
        try {
            reservationService.create(reservation.getDate(), reservation.getPersonName(), reservation.getRoomId());

            return ResponseEntity.ok("A new reservation was created!");
        } catch (Exception e) {
            System.out.println(e);

            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }
}
