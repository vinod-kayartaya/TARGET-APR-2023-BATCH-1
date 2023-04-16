package com.targetindia.programs;

public class UsingVariablesDemo {
    public static void main(String[] args) {
        byte b1;
        short s1 = 102;
        int i1 = 494;
        long l1;
        String my_name = "Vinod"; // not a good naming convention. check sonar lint report
        System.out.println("my_name is " + my_name);

        b1 = 100;

        System.out.println("b1 is " + b1);

        String st1 = "1000";
        String st2="2000";
        String st3 = st1+st2; // concatenation
        System.out.println(st3);

        // use the wrapper class helper methods to convert string into int
        int n1 = Integer.parseInt(st1);
        int n2 = Integer.valueOf(st2); // valueOf uses parseInt, so you may directly use the parseInt
        int n3 = n1+n2;
        System.out.println("n3 is " + n3);

        System.out.println("Range of value in a byte variable = " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("Range of value in a short variable = " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("Range of value in a int variable = " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Range of value in a long variable = " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("Range of value in a float variable = " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("Range of value in a double variable = " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
    }
}
