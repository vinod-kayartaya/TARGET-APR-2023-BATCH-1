package com.targetindia.programs;

import com.targetindia.model.Book;
import com.targetindia.model.BooksUtil;

import static com.targetindia.model.BooksUtil.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class MoreUseOfArrowFunctions {
    public static void main(String[] args) {
        List<Book> books = bookList();
        // book with max page count
        Book b1 = Collections.max(books); // uses the natural ordering of books (pageCount)
        System.out.printf("Book with max page count is %s%n", b1);

        b1 = Collections.max(books, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        System.out.printf("Book with max price is %s%n", b1);

        b1 = Collections.max(books, (a, b) -> a.getTitle().length() - b.getTitle().length());
        System.out.printf("Book with lengthiest title is %s%n", b1);

        Set<Book> bookSet = new TreeSet<>((a, b) -> {
            int r = Double.compare(a.getPrice(), b.getPrice());
            if (r == 0) {
                r = a.getPageCount() - b.getPageCount();
                if (r == 0) {
                    return a.getTitle().compareTo(b.getTitle());
                }
            }
            return r;
        });
        bookSet.addAll(books);
        System.out.println("Books in the bookSet variable:");
        BooksUtil.printBooks(bookSet);

    }


}
