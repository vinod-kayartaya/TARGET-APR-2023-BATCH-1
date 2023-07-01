package com.targetindia.programs;

import com.targetindia.model.Book;

public class CreateBooks {
    public static void main(String[] args) {
        Book b1;

        b1 = new Book();
        b1.setTitle("Let us C");
        b1.setAuthor("Yashwant Kanetkar");
        b1.setPrice(459);
        b1.setPageCount(299);

        Book b2 = new Book("Java guide", "Vinod K", 899, 674);
        Book b3 = new Book("Java Reference 2023", "Vinod K");
        b1.setPrice(-783);
        b1.setPageCount(576);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
