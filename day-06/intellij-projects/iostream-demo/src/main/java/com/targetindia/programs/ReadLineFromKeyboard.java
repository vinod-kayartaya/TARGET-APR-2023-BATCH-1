package com.targetindia.programs;

import java.io.IOException;
import java.util.Arrays;

public class ReadLineFromKeyboard {

    static String readLine(int size) throws IOException {
        byte[] bytes = new byte[size];
        System.in.read(bytes);
        return new String(bytes).trim();
    }

    public static void main(String[] args) throws IOException {
        System.out.printf("Enter your name: ");
        String name = readLine(50);
        System.out.printf("Enter your email address: ");
        String email = readLine(100);
        System.out.printf("Enter your age: ");
        int age= Integer.parseInt(readLine(3));

        System.out.printf("Name   : %s%n", name);
        System.out.printf("Email  : %s%n", email);
        System.out.printf("Age    : %d years%n", age);
    }

    public static void mainOld(String[] args) throws Exception {

        byte[] bytes = new byte[128];
        System.out.printf("Enter your name: ");
        System.in.read(bytes);
        System.out.printf("bytes = %s%n", Arrays.toString(bytes));
        String name = new String(bytes).trim();
        System.out.printf("name.length() = %d%n", name.length());
        System.out.printf("Hello, %s! how are you today?%n", name);
    }
}
