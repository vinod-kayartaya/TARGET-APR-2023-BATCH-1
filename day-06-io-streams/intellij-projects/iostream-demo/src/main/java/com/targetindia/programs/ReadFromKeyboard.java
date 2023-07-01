package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFromKeyboard {
    public static void main(String[] args) throws Exception {
        // convert an InputStream to a Reader using the class InputStreamReader
        InputStreamReader isr = new InputStreamReader(System.in); // InputStreamReader IS-A Reader
        BufferedReader in = new BufferedReader(isr);

        String name;
        String city;
        int age;

        System.out.printf("What's your name? ");
        name = in.readLine();
        System.out.printf("Where are you from? ");
        city = in.readLine();
        System.out.printf("How old are you? ");
        age = Integer.parseInt(in.readLine());

        System.out.printf("Name   : %s%n", name);
        System.out.printf("City   : %s%n", city);
        System.out.printf("Age    : %d years%n", age);
    }
}
