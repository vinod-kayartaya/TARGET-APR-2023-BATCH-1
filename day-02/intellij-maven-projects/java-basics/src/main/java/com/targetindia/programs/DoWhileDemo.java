package com.targetindia.programs;

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {

        int choice = menu();
        System.out.println("Your choice was " + choice);
    }

    static int menu() {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Search customers by id");
            System.out.println("2. Search customers by email");
            System.out.println("3. Search customers by phone");
            System.out.println("4. Search customers by city");
            System.out.println("5. Exit");
            System.out.printf("Enter your choice >> ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please enter 1 to 5.");
            }
        } while (choice < 1 || choice > 5);

        return choice;
    }
}
