package com.targetindia.programs;

import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        // checkIfInputMonthIsValid();
        checkAndPrintNoOfDaysInMonth();
    }

    private static void checkAndPrintNoOfDaysInMonth() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value for month (1 to 12): ");
        int m = sc.nextInt();
        int days = getMaxDaysInMonth(m);
        if (days == -1) {
            System.out.println("Invalid month supplied - " + m);
        } else {
            System.out.printf("Month number %d has %d days.\n", m, days);
        }
    }

    static int getMaxDaysInMonth(int month) {
        if (month < 1 || month > 12) {
            return -1;
        }

        if (month == 2) {
            return 28;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }

    static void checkIfInputMonthIsValid() {
        // accept value from keyboard
        // System.in represents the keyboard, just like System.out represents monitor
        // The class java.util.Scanner allows scanning from any input devices (like keyboard, mouse, file etc)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value for month (1 to 12): ");
        int month = sc.nextInt(); // if you type 45 and press enter, then in the keyboard buffer, these characters
        // will be there - '4', '5' and '\n'.
        // sc.nextInt() will try to read only integer letters and make it a whole integer number and returns 45

        if (month < 1 || month > 12) {
            System.out.println("Invalid value for month - " + month);
        } else {
            System.out.println(month + " is a valid month number.");
        }
    }
}
