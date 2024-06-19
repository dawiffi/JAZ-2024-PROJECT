package com.example.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    private String genre;
    private double price;
    private int pages;
    private int visitCount;
    private boolean available;
    private int stock;
}
