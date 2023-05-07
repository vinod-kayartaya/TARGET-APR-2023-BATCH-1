# Functional programming 

- A function is a first class object (in languages that support functional programming)
- You can pass a function as an argument of a function
- You can return a function from anohter function
- You can assign a function to a variable
    - not in Java

## Functional interface

- An interface with exactly 1 abstract method
- Can also be annotated with `@FunctionalInterface`
- In Java, we can assign an object of any interface to a variable
    - Since in a functional interface, there is exactly 1 abstract function signature, we can assign an implementation for that function to a variable of a functional interface

For example, the interface called `java.lang.Runnable` has one abstract method `public void run()`.

```java
Runnable r1 = new Runnable() {
    public void run(){
        System.out.println("Hello");
    }
};

// idea is
Runnable r2 = public void run(){
    System.out.println("Hello");
};
// should be done as
Runnable r2 = ()->{
    System.out.println("Hello");
};
// can be simplified as
Runnable r2 = ()->System.out.println("Hello");
```

If the method body has only one statement, then we do not need the curly braces. If the olny statement is a return statement, then the return keyword is also not required.

```java
Comparator<Book> cmp = new Comparator<>(){
    public int compare(Book b1, Book b2){
        return Double.compare(b1.getPrice(), b2.getPrice());
    }
}
// can be simplified as 
Comparator<Book> cmp = (Book b1, Book b2) -> {
        return Double.compare(b1.getPrice(), b2.getPrice());
    };

// can further be simplified as 
Comparator<Book> cmp = (b1, b2) -> {
        return Double.compare(b1.getPrice(), b2.getPrice());
    };

// can further be simplified as 
Comparator<Book> cmp = (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice());
```