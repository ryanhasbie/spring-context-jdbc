package org.enigpush.repository;

import org.enigpush.model.Book;
import org.enigpush.util.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookArrayRepository implements IBookRepository {
    @Autowired
    @Qualifier("randomUuid")
    private IRandomStringGenerator stringGenerator;
    private List<Book> books = new ArrayList<>();

    public BookArrayRepository(IRandomStringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
    }

    @Override
    public List<Book> getAll() throws Exception {
        return books;
    }

    @Override
    public Book create(Book book) throws Exception {
        book.setCode(stringGenerator.random());
        books.add(book);
        return book;
    }

    @Override
    public Optional<Book> findByTitle(String title) throws Exception {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Book book, String code) throws Exception {
        for (Book b : books ) {
            if (b.getCode().equals(code)) {
                b.setTitle(book.getTitle());
                b.setPublisher(book.getPublisher());
                b.setPublicationYear(book.getPublicationYear());
                b.setAuthor(book.getAuthor());
                break;
            }
        }
    }

    @Override
    public void delete(String code) throws Exception {
        for (Book book : books) {
            if (book.getCode().equals(code)) {
                books.remove(book);
                break;
            }
        }
    }

    @Override
    public void createBulk(List<Book> books) throws Exception {
        this.books.addAll(books);
    }
}
