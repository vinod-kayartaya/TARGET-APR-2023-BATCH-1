package com.targetindia.programs;

public class InterruptedExceptionDemo {

    static void sleep(long duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Start of main");

        Thread t = new Thread(() -> {
            for (int i = 0; ; i++) {
                // sleep(100);
            }
        });
        t.start();

        try {
            t.join();
            System.out.println("Waiting is over!");
        } catch (InterruptedException e) {
            // throw new RuntimeException(e);

        }

        System.out.println("End of main");
    }
}
