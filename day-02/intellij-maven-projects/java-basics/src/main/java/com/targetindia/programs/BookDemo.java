package com.targetindia.programs;

import com.targetindia.model.Book;

public class BookDemo {
    public static void main(String[] args) {
        Book b1; // reference
        b1 = new Book();

        // cannot access private members
//        b1.title = "Let us C";
//        b1.price = 240;
//        b1.author = "Yashwant Kanetkar";
//        b1.pageCount= 299;

        b1.setTitle("Let us C");
        b1.setPrice(240);
        b1.setPageCount(299);
        b1.setAuthor("Yashwant Kanetkar");

        System.out.println("b1 is " + b1);
        b1.print();

        System.out.printf("The book with title '%s' costs %.1f rupees.\n",
                b1.getTitle(), b1.getPrice());


    }
}
