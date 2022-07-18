package com.springboot.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data // dont have to write getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate birthday;
}
