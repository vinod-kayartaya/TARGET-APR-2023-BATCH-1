package com.targetindia.programs;

import java.util.stream.Stream;

public class StreamsDemo3 {
    public static void main(String[] args) {
        // TRY DOING THIS WITHOUT STREAMS
        Stream.of("Vinod", "Shyam", "Vinay", "Vijay", "Kiran", "Kishore", "Nimesh", "Nagesh")
                .filter(name -> name.charAt(1) == 'i') // Vinod, Vinay, Vijay, Kiran, Kishore, Nimesh
                .map(name -> name.substring(0, 3)) // Vin, Vin, Vij, Kir, Kis, Nim
                .distinct() // Vin, Vij, Kir, Kis, Nim
                .map(String::toUpperCase) // VIN, VIJ, KIR, KIS, NIM
                .sorted() // KIR, KIS, NIM, VIJ, VIN
                .forEach(System.out::println);

    }
}
