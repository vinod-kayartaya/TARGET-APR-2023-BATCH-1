package com.targetindia.programs;

import com.targetindia.model.Book;
import com.targetindia.model.BooksUtil;

import java.util.*;

import static com.targetindia.model.BooksUtil.printBooks;

public class ArrowFunctionDemo {

    public static void main(String[] args) {

        List<Book> books = BooksUtil.bookList();
        System.out.printf("There are %d books%n", books.size());

        printBooks(books);
        System.out.println("Books sorted by their page count: ");
        Collections.sort(books); // the default 'natural ordering' of Book used here
        printBooks(books);

        Comparator<Book> cmp = new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        };
        System.out.println("Books sorted by their title: ");
        Collections.sort(books, cmp); // supply the logic for comparing two books by title
        printBooks(books);

//        cmp = (Book book1, Book book2) -> {
//            return Double.compare(book1.getPrice(), book2.getPrice());
//        };

        cmp = (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
        System.out.println("Books sorted by their price: ");
        Collections.sort(books, cmp); // supply the logic for comparing two books by price
        printBooks(books);

        System.out.println("Books sorted by their price in reverse order: ");
        Collections.sort(books, (book1, book2) -> Double.compare(book2.getPrice(), book1.getPrice())); // supply the logic for comparing two books by price
        printBooks(books);


    }
}
