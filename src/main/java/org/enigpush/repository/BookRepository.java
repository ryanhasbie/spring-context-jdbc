package org.enigpush.repository;

import org.enigpush.model.Book;
import org.enigpush.model.mapper.BookMapper;
import org.enigpush.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IRandomStringGenerator randomStringGenerator;

    private final String SQL_GET_ALL = "select * from books";
    private final String SQL_INSERT_BOOK = "insert into books values(?,?,?,?,?)";
    private final String SQL_FIND_BY_TITLE = "select * from books where title = ?";
    private final String SQL_UPDATE_BOOK = "update books set title = ?, publisher=?, publicationYear=?, author=? where code = ?";
    private final String SQL_DELETE_BOOK = "delete from books where code=?";

    public BookRepository (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new BookMapper());
        } catch (DataAccessException e) {
            System.out.println("ini gagal ------------");
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Book create(Book book) throws Exception {
        try {
            book.setCode(randomStringGenerator.random());
            int result = jdbcTemplate.update(SQL_INSERT_BOOK, book.getCode(), book.getTitle(), book.getPublisher(), book.getPublicationYear(), book.getAuthor());
            if (result <= 0) {
                throw new Exception("Failed to insert book!");
            }
            return book;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Book> findByTitle(String title) throws Exception {
        try {
            Book book = jdbcTemplate.queryForObject(SQL_FIND_BY_TITLE, new BookMapper(), new Object[]{title});
            return Optional.ofNullable(book);
        } catch (DataAccessException e) {
            throw new Exception("Failed to get course!");
        }
    }

    @Override
    public void update(Book book, String code) throws Exception {
        try {
            jdbcTemplate.update(SQL_UPDATE_BOOK, book.getTitle(), book.getPublisher(), book.getPublicationYear(), book.getAuthor(), code);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String code) throws Exception {
        try {
            jdbcTemplate.update(SQL_DELETE_BOOK, code);
        } catch (DataAccessException e) {
            throw new Exception("Failed to delete course!");
        }
    }

    @Override
    public void createBulk(List<Book> books) throws Exception {
        try {
            jdbcTemplate.batchUpdate("insert into books (code, title, publisher, publicationYear, author) " + "VALUES (?,?,?,?,?)", books, 100, (PreparedStatement ps, Book book) -> {
                ps.setString(1, book.getCode());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getPublisher());
                ps.setString(4, book.getPublicationYear());
                ps.setString(5, book.getAuthor());
            });
        } catch (DataAccessException e) {
            throw new Exception("Failed to create bulk!");
        }
    }
}
