package com.springboot.bookstore.controller;

import com.springboot.bookstore.entity.Book;
import com.springboot.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public List<Book> findAllProducts(){
        System.out.println(bookService.getBooks());
        return bookService.getBooks();
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {

        return bookService.saveBook(book);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    @DeleteMapping("/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }

    @PostMapping("/bookByTitle/{title}")
        public List<Book> findBookByTitle(@PathVariable String title){
            return bookService.getBookByTitle(title);
        }

    @PostMapping("/bookByAuthor/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }

}
