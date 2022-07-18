package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,String> {
    List<Book> findByTitle(String title);
   // Book findByAuthor(List<String> author);
    @Query(nativeQuery = true, value = "SELECT * FROM bookstore.books where JSON_SEARCH(author, 'one', ?1);")
    List<Book> findByAuthor(String author);
}
