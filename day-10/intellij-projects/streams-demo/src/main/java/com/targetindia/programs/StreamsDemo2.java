package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamsDemo2 {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(63, 492, 39, 2, 49, 482, 284, 221, 5566);
        double total = 0;
        for (int n : nums) {
            total += n;
        }
        double avg = total / nums.size();
        System.out.printf("avg = %.30f%n", avg);
        System.out.println("------------------------");


        avg = IntStream.of(63, 492, 39, 2, 49, 482, 284, 221, 5566)
                .average()
                //.ifPresent(System.out::println);
                .getAsDouble();
        System.out.printf("avg using streams = %.30f%n", avg);
        System.out.println("------------------------");

        IntStream.range(0, 5) // 0 to 4
                .forEach(System.out::println);
        System.out.println("------------------------");
        IntStream.rangeClosed(0, 5) // 0 to 5
                .forEach(System.out::println);

        System.out.println("------------------------");
        // print the square root of all even numbers from 100 to 125
        IntStream.rangeClosed(100, 125)// 100, 101, 102, 103, 104, 105, ... 125
                .filter(n -> n % 2 == 0) // 100, 102, 104, 106, ...124
                .mapToDouble(n -> (double) n) // 100.0, 102.0, 104.0, 106.0, ...124.0
                .map(Math::sqrt) // 10, 10.0995, 10.1980, 10.2956, ...11.1355
                .forEach(System.out::println);
        System.out.println("------------------------");

    }
}
