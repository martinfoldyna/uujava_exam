package com.example.exam.controllers;

import com.example.exam.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

class CreateReservationBody {
    private String reservationStart;
    private String reservationEnd;
    private Integer bookId;
    private String reservedBy;

    public CreateReservationBody() {
    }

    public String getReservationStart() {
        return this.reservationStart;
    }

    public String getReservationEnd() {
        return this.reservationEnd;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public String getReservedBy() {
        return this.reservedBy;
    }
}

class UpdateReservationBody extends CreateReservationBody{

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
            reservationService.create(reservation.getReservationStart(), reservation.getReservationEnd(), reservation.getBookId(), reservation.getReservedBy());

            return ResponseEntity.ok("A new reservation was created!");
        } catch (Exception e) {
            System.out.println(e);

            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }
    @PutMapping("")
    public ResponseEntity<String> createReservation(@RequestBody CreateReservationBody reservation) {
        try {
            reservationService.update(reservation.getReservationStart(), reservation.getReservationEnd(), reservation.getBookId(), reservation.getReservedBy());

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
