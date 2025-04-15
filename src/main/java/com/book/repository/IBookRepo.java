package com.book.repository;

import com.book.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book> {
    
    public static Specification<Book> hasTitle(String title) {
        return  (root, query, criteriaBuilder) -> title == null ? null : criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Book> hasAuthor(String author) {
        return  (root, query, criteriaBuilder) -> author == null ? null : criteriaBuilder.like(root.get("author"), "%" + author + "%");
    }

    public static Specification<Book> hasPublicationYear(String publicationYear) {
        return  (root, query, criteriaBuilder) -> publicationYear == null ? null : criteriaBuilder.like(root.get("publicationYear"), "%" + publicationYear + "%");
    }

    public static Specification<Book> hasIsbn(String isbn) {
        return  (root, query, criteriaBuilder) -> isbn == null ? null : criteriaBuilder.like(root.get("isbn"), "%" + isbn + "%");
    }
}
