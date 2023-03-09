package org.enigpush.service;

import org.enigpush.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> list();
    public Book create(Book book);
    public void update(Book book, String code);
    public void delete(String code);
    public Book findByTitle(String title) throws Exception;
    public void createBulk(List<Book> books);
}
