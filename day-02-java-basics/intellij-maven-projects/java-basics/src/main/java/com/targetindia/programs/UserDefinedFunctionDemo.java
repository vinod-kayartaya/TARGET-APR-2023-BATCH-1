package com.targetindia.programs;

public class UserDefinedFunctionDemo {

    static void sayHello(){
        System.out.println("Hello world!");
    }

    static void sayHello(String name){
        System.out.printf("Hello, %s\n", name);
    }

    public static void main(String[] args) {
        System.out.println("This is the first line of output");
        sayHello();
        sayHello();
        sayHello("Vinod");
        sayHello("Shyam");
        System.out.println("This is the last line of output");
    }
}
