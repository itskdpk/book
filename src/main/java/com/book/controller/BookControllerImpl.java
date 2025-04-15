package com.book.controller;

import com.book.model.Book;
import com.book.service.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements IBookController {

    private final IBookService bookService;

    @Override
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    public Book getBookById(String id) {
        return bookService.getBookById(id);
    }

    @Override
    public List<Book> searchBook(Book book) {
        return bookService.searchBook(book);
    }

    @Override
    public Book addBook(@Valid Book book) {
        return bookService.addBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookService.updateBook(book);
    }

    @Override
    public Book patchBook(Book book) {
        return bookService.patchBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookService.deleteBook(id);
    }
}
