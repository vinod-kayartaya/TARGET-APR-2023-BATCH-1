package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintCalendar {
    static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    static int maxDays(int year) {
        return isLeap(year) ? 366 : 365;
    }

    static int maxDays(int month, int year) {
        switch (month) {
            case 2:
                return isLeap(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 31;
    }

    static int julianDate(int day, int month, int year) {
        int jd = day;
        for (int y = 1900; y < year; y++) {
            jd += maxDays(y);
        }
        for (int m = 1; m < month; m++) {
            jd += maxDays(m, year);
        }
        return jd;
    }


    public static void main(String[] args) {
        int month;
        int year;

        if (args.length == 2) {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } else {
            month = KeyboardUtil.getInt("Enter month: ");
            year = KeyboardUtil.getInt("Enter year: ");
        }

        int md = maxDays(month, year);
        int jd = julianDate(1, month, year);
        int wd = jd % 7;


        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < wd; i++) {
            System.out.print("   "); // 3 spaces
        }

        for (int d = 1; d <= md; d++) {
            System.out.printf("%2d ", d);
            if ((wd + d) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
