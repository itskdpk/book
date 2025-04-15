package com.book.service;

import com.book.model.Book;


import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    Book getBookById(String id);

    List<Book> searchBook(Book book);

    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(String id);

    Book patchBook(Book book);
}
