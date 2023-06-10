package com.example.exam.services;

import com.example.exam.services.schemas.AuthorServiceSchema;
import com.example.spring_demo.schemas.Reservation;
import com.example.spring_demo.services.schemas.ReservationServiceSchema;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class AuthorService implements AuthorServiceSchema {
    private HashMap<UUID, Reservation> reservations;

    public void BookService() {
        this.reservations = new HashMap<>();
    }

    private ArrayList<Reservation> getAllReservations() throws IllegalArgumentException {
        ArrayList<Reservation> allReservations = new ArrayList<>(reservations.values());

        return allReservations;
    }

    public ArrayList<Reservation> create(String date, String parsonName, Integer roomId) {
        String[] splitDate = date.split("[.]");

        if (splitDate.length < 3) throw new IllegalArgumentException("You entered a wrong date!");
        Integer day = Integer.parseInt(splitDate[0]);
        Integer month = Integer.parseInt(splitDate[1]);
        Integer year = Integer.parseInt(splitDate[2]);

        Reservation newReservation = new Reservation(LocalDate.of(year, month, day), parsonName, roomId);

        reservations.put(newReservation.getId(), newReservation);

        return this.getAllReservations();
    }

    public ArrayList<Reservation> findAll() {
        return this.getAllReservations();
    }

    public Reservation findOne(String id) {
        return reservations.get(id);
    }

    public Reservation update(UUID id, Reservation newReservation) {
        reservations.put(id, newReservation);

        return newReservation;
    }
}
