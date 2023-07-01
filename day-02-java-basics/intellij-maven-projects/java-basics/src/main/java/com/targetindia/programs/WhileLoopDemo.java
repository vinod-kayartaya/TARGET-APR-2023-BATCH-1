package com.targetindia.programs;

import java.util.Scanner;

public class WhileLoopDemo {
    public static void main(String[] args) {
        // accept a number and print the biggest fibonacci element less the input
        // for example, if 100 is the input, the largest fibonacci element less than 100 should be printed
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter a number: ");
        int limit = sc.nextInt();

        if (limit < 0) {
            System.out.println("Try with a number >= 0");
            return;
        }

        if (limit == 0) {
            System.out.println("output is 0");
            return;
        }
        if (limit == 1) {
            System.out.println("output is 1");
            return;
        }
        int a = -1;
        int b = 1;
        int c = 0;
        while (c < limit) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.printf("output is %d\n", a);

    }
}
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,