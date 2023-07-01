package com.targetindia.programs;

import java.util.Scanner;

public class ForLoopDemo {
    public static void main(String[] args) {
        printFactorialOfInputNumber();

    }

    private static void printFactorialOfInputNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter a number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Factorial is calculated only for non-negative numbers");
            return;
        }

        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i; // f = f * i;
        }
        System.out.printf("Factorial of %d is %d\n", n, f);
    }
}
