package com.targetindia.programs;

import java.util.Scanner;

public class SwitchCaseDemo {
    public static void main(String[] args) {
        // acceptAndPrintWeekDayName();
        printNumberOfDaysInGivenMonthOfYear();
    }

    private static void printNumberOfDaysInGivenMonthOfYear() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter year: ");
        int year = sc.nextInt();

        if (year < 1900) {
            System.out.println("Year must be >=1900");
            return;
        }

        System.out.printf("Enter month: ");
        int month = sc.nextInt();


        if (month < 1 || month > 12) {
            System.out.println("Month must be between 1 and 12");
            return;
        }

        int maxDays;

        switch (month) {
            case 2:
                maxDays = (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            default:
                maxDays = 31;
        }
        System.out.printf("Number of days in %d/%d is %d\n", month, year, maxDays);
    }

    private static void acceptAndPrintWeekDayName() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number for weekday (1 to 7): ");
        int day = sc.nextInt();
        if (day < 1 || day > 7) {
            System.out.println("Invalid value input!");
            return;
        }
        String dayName;
        switch (day) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            case 6:
                dayName = "Friday";
                break;
            default:
                dayName = "Saturday";
        }
        System.out.printf("The day number %d is %s\n", day, dayName);

    }
}
