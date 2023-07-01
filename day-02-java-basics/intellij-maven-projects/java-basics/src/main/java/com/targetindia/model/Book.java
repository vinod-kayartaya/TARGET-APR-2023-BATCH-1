package com.targetindia.model;

public class Book {
    private String title;
    private String author;
    private double price;
    private int pageCount;

    public void setTitle(String title) {
        // do some checks on title
        this.title = title;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new RuntimeException("Price must be >0");
        }
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void print() {
        System.out.printf("Title       : %s\n", this.title);
        System.out.printf("Author      : %s\n", this.author);
        System.out.printf("No.of pages : %s\n", this.pageCount);
        System.out.printf("Price       : Rs.%.1f\n", this.price);
    }

    // returns a textual representation of an object.
    // An object of this class can be treated a String.
    // This method is automatically called by System.out.print functions or
    // whenever you are concatenating this object with a string.
    // For example, "b1 is " + b1 --> "b1 is " + b1.toString()
//    public String toString() {
//        return "Book (title='" + title + "', author='" + author + "', price=" + price + ", pageCount=" + pageCount + ")";
//    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pageCount=" + pageCount +
                '}';
    }
}
