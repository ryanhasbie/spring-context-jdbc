package org.enigpush;

import org.enigpush.config.BeanConfigurationDev;
import org.enigpush.config.BeanConfigurationProd;
import org.enigpush.model.Book;
import org.enigpush.service.IBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        production
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(BeanConfigurationProd.class);
//        ctx.refresh();

//        getAll
//        IBookService iBookService = ctx.getBean(IBookService.class);
//        List<Book> books = iBookService.list();
//        System.out.println(books.size());
//        for (Book book : books) {
//            System.out.println(book.toString());
//        }

//          Create
//        IBookService bookService = ctx.getBean(IBookService.class);
//        Book pengabdiSetan = new Book();
//        pengabdiSetan.setTitle("Pengabdi Setan");
//        pengabdiSetan.setPublisher("PT. Falcon");
//        pengabdiSetan.setPublicationYear("2018");
//        pengabdiSetan.setAuthor("Djoko Anwar");
//        bookService.create(pengabdiSetan);

//        findByTitle
//        try {
//            IBookService bookService = ctx.getBean(IBookService.class);
//            Book book = bookService.findByTitle("Laskar Pelangi");
//            System.out.println(book);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        update
//        IBookService bookService = ctx.getBean(IBookService.class);
//        Book book = new Book();
//        book.setTitle("Dragon Ball");
//        book.setPublisher("PT. Xyz");
//        book.setPublicationYear("2023");
//        book.setAuthor("Ryan Hasbie");
//        bookService.update(book, "123");

//        delete
//        IBookService bookService = ctx.getBean(IBookService.class);
//        bookService.delete("ce09c5c0-cadd-4b20-b822-5838a4c8c2e0");

//        createBulk
//        IBookService bookService = ctx.getBean(IBookService.class);
//        Book book1 = new Book("123", "Apa ajah", "PT. Abc", "2012", "Goku");
//        Book book2 = new Book("456", "Rahasia", "PT. Sjh", "2014", "Ryan");
//        List<Book> books = List.of(book1, book2);
//        bookService.createBulk(books);

//        local
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(BeanConfigurationDev.class);
//        ctx.refresh();
//
//        IBookService bookService = ctx.getBean(IBookService.class);
//        Book pengabdiSetan = new Book();
//        pengabdiSetan.setTitle("Pengabdi Setan");
//        pengabdiSetan.setPublisher("PT. Falcon");
//        pengabdiSetan.setPublicationYear("2018");
//        pengabdiSetan.setAuthor("Djoko Anwar");
//        bookService.create(pengabdiSetan);
    }
}