package com.targetindia.programs;

import java.io.IOException;

public class KeyboardInputDemo {
    public static void main(String[] args) throws Exception {
        System.out.printf("System.in is an object of type: %s%n",
                System.in.getClass().getName());

        System.out.println("System.in represents Keyboard");
        System.out.printf("Enter your name: ");
        int ch;

        String name = "";
        while ((ch = System.in.read()) != '\n') {
            name += (char) ch;
        }

        System.out.printf("Hello, %s!", name);
    }
}
