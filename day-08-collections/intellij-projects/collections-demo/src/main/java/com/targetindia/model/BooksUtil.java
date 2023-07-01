package com.targetindia.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BooksUtil {
    public static List<Book> bookList() {
        Book b1 = new Book("Let us C", 459.0, 178);
        Book b2 = new Book("C Pearls", 459.0, 234);
        Book b3 = new Book("Let us Absorb Maths", 459.0, 178);
        Book b4 = new Book("Java in detail", 1230.0, 897);
        Book b5 = new Book("C Pearls", 459.0, 234); // duplicate of b2
        Book b6 = new Book("All about Java", 2990, 1578);
        Book b7 = new Book("All about Java, 2nd edition", 2590, 1676);
        Book b8 = new Book("HTML Basics", 559, 178);
        Book b9 = new Book("HTML, CSS and JavaScript - Basics to Advanced", 359, 234);

        List<Book> books = new ArrayList<>();
        books.addAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9));
        return books;
    }

    public static void printBooks(Collection<Book> books) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-50s %10s %4s%n", "Title", "Price", "Pages");
        System.out.println("---------------------------------------------------------------------------");
        for (Book b : books) {
            System.out.printf("%-50s %10.2f %4d%n", b.getTitle(), b.getPrice(), b.getPageCount());
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
