package com.example.exam.controllers;

import com.example.exam.schemas.Book;
import com.example.exam.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

class CreateBookBody {
    private String name;
    private String personName;
    private Integer roomId;

    public CreateBookBody() {}

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
public class BookController {

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
