package com.example.exam.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.exam.entities.Book;
import org.springframework.jdbc.core.RowMapper;


public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int arg1) throws SQLException {
        Book book = new Book();
        book.setEmployeeId(rs.getString("bookloyeeId"));
        book.setEmployeeName(rs.getString("bookloyeeName"));
        book.setEmployeeEmail(rs.getString("bookloyeeEmail"));

        return book;
    }


}
