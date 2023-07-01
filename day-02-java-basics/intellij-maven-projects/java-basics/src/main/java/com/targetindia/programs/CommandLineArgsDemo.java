package com.targetindia.programs;

import java.util.Arrays;

public class CommandLineArgsDemo {
    public static void main(String[] args) {
        System.out.printf("args is %s\n", Arrays.toString(args));
        System.out.printf("no.of command line arguments is %d\n", args.length);
    }
}
