package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anil", "Vinod", "Ashwath", "Arvind", "Arun", "Vinay", "Vijay");

        // print all the names that start with "A"
        // old traditional approach
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
        System.out.println("---------------------------");

        // new approach, using functional programming
        names
                .stream() // attach a stream API to the List object
                .filter(name -> name.startsWith("A")) // takes an object of a functional-interface called Predicate
                //.sorted()
                .forEach(name -> System.out.println(name)); // takes an object of a functional-interface called Consumer
        System.out.println("---------------------------");

        names
                .parallelStream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println); // forEach directly calls the println method of System.out and passes the parameter
        System.out.println("---------------------------");


        Stream.of(9281, 31, 941, 8, 29, 4381, 193, 861, 433)
                .filter(num -> num % 2 == 0)
                .findFirst()
                //.ifPresent(System.out::println);
                .ifPresentOrElse(System.out::println, () -> System.out.println("No even numbers"));

        // ifPresentOrElse --> takes 2 arguments
        // 1. a Consumer, which is an arrow function that receives one argument, and does not return a value
        // 2. a Runnable, which is an arrow function that takes 0 argument and does not return a value
        System.out.println("---------------------------");
    }
}
