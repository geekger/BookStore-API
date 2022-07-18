package com.springboot.bookstore.service;

import com.springboot.bookstore.entity.Book;
import com.springboot.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    Book book;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book ) { return bookRepository.save(book); }

    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getIsbn()).orElse(null);
        existingBook.setIsbn(book.getIsbn()); // in the event wrong isbn number is entered we should allow it to be modified still
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setYear(book.getYear());
        existingBook.setPrice(book.getPrice());
        existingBook.setGenre(book.getGenre());
        return bookRepository.save(existingBook);
    }

    public String deleteBook(String isbn){
        bookRepository.deleteById(isbn);
        return "Book with isbn:" + isbn + "deleted";
    }

    public List<Book> getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBookByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }
}
