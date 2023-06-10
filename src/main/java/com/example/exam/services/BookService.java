package com.example.exam.services;

import com.example.exam.schemas.Book;
import com.example.exam.services.schemas.BookServiceSchema;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class BookService implements BookServiceSchema {
    private HashMap<UUID, Book> books;

    public BookService() {
        this.reservations = new HashMap<>();
    }

    private ArrayList<Book> getAllBooks() throws IllegalArgumentException {
        ArrayList<Book> allBooks = new ArrayList<>(books.values());

        return allBooks;
    }

    //public ArrayList<Book> create(String date, String parsonName, Integer roomId) {
    //    String[] splitDate = date.split("[.]");

    //    if (splitDate.length < 3) throw new IllegalArgumentException("You entered a wrong date!");
    //    Integer day = Integer.parseInt(splitDate[0]);
    //    Integer month = Integer.parseInt(splitDate[1]);
    //  Integer year = Integer.parseInt(splitDate[2]);

    //  Reservation newReservation = new Reservation(LocalDate.of(year, month, day), parsonName, roomId);

    //  reservations.put(newReservation.getId(), newReservation);

    //  return this.getAllReservations();
    //}

    public ArrayList<Book> findAll() {
        return this.getAllBooks();
    }

    public Book findOne(String id) {
        return books.get(id);
    }

    public Book update(UUID id, Book newBook) {
        books.put(id, newBook);

        return newBook;
    }
}
