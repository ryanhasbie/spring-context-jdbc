package org.enigpush.service;

import org.enigpush.model.Book;
import org.enigpush.repository.IBookRepository;

import java.util.List;
import java.util.Optional;

public class BookService implements IBookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> list() {
        try {
            return bookRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book create(Book book) {
        try {
            return bookRepository.create(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book, String code) {
        try {
            bookRepository.update(book, code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String code) {
        try {
            bookRepository.delete(code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findByTitle(String title) throws Exception {
        Optional<Book> result = bookRepository.findByTitle(title);
        if (result.isEmpty()) {
            throw new Exception("Book not found");
        }
        return result.get();
    }

    @Override
    public void createBulk(List<Book> books) {
        try {
            bookRepository.createBulk(books);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
