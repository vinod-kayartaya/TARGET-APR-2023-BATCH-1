package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class KeyboardUtil {

    private KeyboardUtil() {
    }

    public static int getInt(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getString(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static double getDouble(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static Date getDate(String message) {
        System.out.print(message + " (dd/mm/yyyy) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            return null;
        }
    }
}