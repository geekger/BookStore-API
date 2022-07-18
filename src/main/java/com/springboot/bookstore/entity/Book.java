package com.springboot.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Books")
public class Book {

    @Id
    private String isbn;

    private String title;

    private String author; //create another table that matches author to their books

    private Date year;

    private double price;

    private String genre;

}
