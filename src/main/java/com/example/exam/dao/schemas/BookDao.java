package com.example.exam.dao.schemas;

import com.example.exam.entities.Book;

import java.util.List;

public interface BookDao {

        List<Book> findAll();

        void insertBook(Book emp);

        void updateBook(Book emp);

        void executeUpdateBook(Book emp);

        public void deleteBook(Book emp);
}
