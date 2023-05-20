package com.targetindia.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("vinod", "vinay", "arun", "ajay", "kumar", "kushal");

        names.stream()
                //.sorted((a, b)->a.compareTo(b))
                .sorted(String::compareTo)
                .forEach(System.out::println);

    }
}
