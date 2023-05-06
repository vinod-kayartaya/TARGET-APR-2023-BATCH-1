package com.targetindia.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable<Book>{ // Comparable adds "natural ordering" for a book
    private String title;
    private double price;
    private int pageCount;

    @Override
    public int compareTo(Book other) {
        int r = this.pageCount - other.pageCount;
        if(r==0){
            r = Double.compare(this.price, other.price);
            if(r==0){
                return this.title.compareTo(other.title);
            }
        }
        return r;
    }
}
