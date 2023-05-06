package com.targetindia.programs;

import com.targetindia.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SetOfBooks {
    public static void main(String[] args) {
        Book b1 = new Book("Let us C", 459.0, 178);
        Book b2 = new Book("C Pearls", 459.0, 178);
        Book b3 = new Book("Let us C", 459.0, 178); // duplicate of b1
        Book b4 = new Book("Java in detail", 1230.0, 897);
        Book b5 = new Book("C Pearls", 459.0, 178); // duplicate of b2

        Set<Book> books = new TreeSet<>(Arrays.asList(b1, b2, b3, b4, b5));

        log.trace("# of books = {}", books.size());
        for(Book b: books){
            log.trace("book = {}", b);
        }
    }
}
