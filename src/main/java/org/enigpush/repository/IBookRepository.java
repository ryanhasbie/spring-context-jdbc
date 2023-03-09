package org.enigpush.repository;

import org.enigpush.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    public List<Book> getAll() throws Exception;
    public Book create(Book book) throws Exception;
    public Optional<Book> findByTitle(String title) throws Exception;
    public void update(Book book, String code) throws Exception;
    public void delete(String code) throws Exception;
    public void createBulk(List<Book> books) throws Exception;
}
