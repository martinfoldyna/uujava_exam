package com.example.exam.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.exam.dao.schemas.BookDao;
import com.example.exam.entities.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public BookDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Book> findAll() {
        return template.query("select * from employee", new BookRowMapper());
    }
    @Override
    public void insertBook(Book emp) {
        final String sql = "insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values(:employeeId,:employeeName,:employeeEmail,:employeeAddress)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employeeId", emp.getBookId())
                .addValue("employeeName", emp.getBookName())
                .addValue("employeeEmail", emp.getBookEmail())
                .addValue("employeeAddress", emp.getBookAddress());
        template.update(sql,param, holder);

    }

    @Override
    public void updateBook(Book emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employeeId", emp.getBookId())
                .addValue("employeeName", emp.getBookName())
                .addValue("employeeEmail", emp.getBookEmail())
                .addValue("employeeAddress", emp.getBookAddress());
        template.update(sql,param, holder);

    }

    @Override
    public void executeUpdateBook(Book emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("employeeId", emp.getBookId());
        map.put("employeeName", emp.getBookName());
        map.put("employeeEmail", emp.getBookEmail());
        map.put("employeeAddress", emp.getBookAddress());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }

    @Override
    public void deleteBook(Book emp) {
        final String sql = "delete from employee where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("employeeId", emp.getBookId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }{
}
