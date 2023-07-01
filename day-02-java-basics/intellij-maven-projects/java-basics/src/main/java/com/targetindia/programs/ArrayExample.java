package com.targetindia.programs;

import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter a weekday number (1-7): ");
        int weekday = sc.nextInt();

        if (weekday < 1 || weekday > 7) {
            System.out.println("Please try again with valid input.");
            return;
        }

        // String[] weekdayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] weekdayNames = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday".split(",");

        System.out.printf("It's a %s\n", weekdayNames[weekday - 1]);

    }
}
