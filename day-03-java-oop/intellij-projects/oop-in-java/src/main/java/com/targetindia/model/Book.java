package com.targetindia.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private double price;
    private int pageCount;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new RuntimeException("Invalid value for book price");
        }
        this.price = price;
    }
}
