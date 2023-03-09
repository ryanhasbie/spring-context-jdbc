package org.enigpush.model.mapper;

import org.enigpush.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setCode(rs.getString("code"));
        book.setTitle(rs.getString("title"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublicationYear(rs.getString("publicationYear"));
        book.setAuthor(rs.getString("author"));
        return book;
    }
}
