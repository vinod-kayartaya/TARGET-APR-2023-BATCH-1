package com.targetindia.programs;

public class UsingOperatorsDemo {
    public static void main(String[] args) {
        int n1 = 123, n2 = 342;
        System.out.println(n1 + n2);

        System.out.println(n1 / 10); // 12
        System.out.println(n1 % 10); // 3

        System.out.println(n1 + " is an " + ((n1 % 2) == 0 ? "Even" : "Odd") + " number");
        System.out.println(n2 + " is an " + ((n2 % 2) == 0 ? "Even" : "Odd") + " number");


        // n1 in binary is 00000000 00000000 00000000 01111011
        n1 = n1 << 1; // now n1 is 00000000 00000000 00000000 11110110, which is 246
        System.out.println("After left shift by 1, n1 is " + n1);
        n1 <<= 2; // 00000000 00000000 00000011 11011000, which is 984
        System.out.println("After left shift by 2, n1 is " + n1);

    }
}
