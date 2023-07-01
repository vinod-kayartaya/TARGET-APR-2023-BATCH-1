package com.targetindia.programs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String intInputs = "";
        String nonIntInputs = "";
        int inputCount = 0;
        int intCount = 0;
        int nonIntCount = 0;
        int sum = 0;

        while (true) {
            System.out.printf("Enter an integer: ");
            String input = sc.nextLine();
            inputCount++;
            try {
                int num = Integer.parseInt(input);
                intInputs += num + ", ";
                intCount++;
                sum += num;
            } catch (NumberFormatException e) {
                nonIntInputs += input + ", ";
                nonIntCount++;
            }

            System.out.printf("Do you want to continue? (yes/no) [yes]: ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        intInputs = intInputs.substring(0, intInputs.length() - 2);
        nonIntInputs = nonIntInputs.substring(0, nonIntInputs.length() - 2);

        System.out.printf("Number of inputs = %d\n", inputCount);
        System.out.printf("Number of integer inputs = %d\n", intCount);
        System.out.printf("Number of non-integer inputs = %d\n", nonIntCount);
        System.out.printf("Sum of all integer inputs = %d\n", sum);
        System.out.printf("The integer inputs = %s\n", intInputs);
        System.out.printf("The non-integer inputs = %s\n", nonIntInputs);

    }
}
