package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputStreamClosedDemo {
    public static void main1(String[] args) {
        System.out.println("Hello, friend!");
        System.out.println("How are you doing?");
        System.out.close(); // output stream to the console is closed; hence no more outputs!
        System.out.println("This line may not be printed and there is no exception as well!");
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        System.out.printf("Enter your name: ");
        String name = in.readLine();
        System.out.printf("Hello, %s!%n", name);
        System.in.close(); // now input stream from the console input (keyboard) is closed;
        System.out.printf("Enter your city name: ");
        String city = in.readLine();
        System.out.printf("Did it rain in %s yesterday?%n", city);
    }
}
