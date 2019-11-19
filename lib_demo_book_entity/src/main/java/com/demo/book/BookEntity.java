package com.demo.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class BookEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_id")
        private int book_id;

        @Column(name = "book_name")
        private String book_name;

        @Column(name = "book_price")
        private int book_price;

    }

