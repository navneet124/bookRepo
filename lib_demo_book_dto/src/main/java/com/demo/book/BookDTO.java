package com.demo.book;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private int book_id;
    private String book_name;
    private int book_price;
}
