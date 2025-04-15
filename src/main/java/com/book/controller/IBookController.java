package com.book.controller;

import com.book.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * BookController interface for managing book-related operations.
 * This interface defines the methods for handling book data.
 */
@RequestMapping("/book")
public interface IBookController {

    @Operation(summary = "To Fetch all the books")
    @GetMapping
    List<Book> getAllBooks();

    @Operation(summary = "To Fetch the book by id")
    @GetMapping("/{id}")
    Book getBookById(@PathVariable String id);

    @Operation(summary = "To Search book based on multiple parameters i.e author, title...")
    @PostMapping("/search")
    List<Book> searchBook(@RequestBody Book book);

    @Operation(summary = "To Add the books into db, one at a time")
    @PostMapping
    Book addBook(@Valid @RequestBody Book book);

    @Operation(summary = "To Update book details")
    @PutMapping
    Book updateBook(@RequestBody Book book);

    @Operation(summary = "To Update few attributes of a book")
    @PatchMapping
    Book patchBook(@RequestBody Book book);

    @Operation(summary = "To Delete a book by id")
    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id);

}
