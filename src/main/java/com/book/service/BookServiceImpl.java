package com.book.service;

import com.book.model.Book;
import com.book.repository.IBookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Objects;

import static com.book.repository.IBookRepo.hasAuthor;
import static com.book.repository.IBookRepo.hasIsbn;
import static com.book.repository.IBookRepo.hasPublicationYear;
import static com.book.repository.IBookRepo.hasTitle;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List<Book> searchBook(Book book) {
        Specification<Book> specification = Specification
                .where(hasTitle(book.getTitle()))
                .and(hasAuthor(book.getAuthor()))
                .and(hasPublicationYear(book.getPublicationYear()))
                .and(hasIsbn(book.getIsbn()));
        return bookRepo.findAll(specification);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book patchBook(Book book) {
        Book existingBook = bookRepo.findById(book.getId()).orElseThrow(() -> new RuntimeException("Book not found"));
        if(Objects.nonNull(book.getTitle())) {
            existingBook.setTitle(book.getTitle());
        }
        if(Objects.nonNull(book.getAuthor())) {
            existingBook.setAuthor(book.getAuthor());
        }
        if(Objects.nonNull(book.getIsbn())) {
            existingBook.setIsbn(book.getIsbn());
        }
        if(Objects.nonNull(book.getPublicationYear())) {
            existingBook.setPublicationYear(book.getPublicationYear());
        }
        return bookRepo.save(existingBook);
    }
}
