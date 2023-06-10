package com.example.exam.services.schemas;

import com.example.exam.schemas.Book;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.UUID;

public interface BookServiceSchema {

    @PostConstruct
    ArrayList<Book> create(String date, String parsonName, Integer roomId);

    ArrayList<Book> findAll();

    Book findOne(String id);

    Book update(UUID id, Book newReservation);
}
