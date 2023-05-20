package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ThreadDemo2 {


    static class NumbersPrinter implements Runnable {
        // Runnable is a functional interface, which means,
        // we can use just an arrow function, instead of this whole class

        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                int n = new Random().nextInt(100, 200);
                log.trace("inside the NumbersPrinter.run() executed using the thread '{}', value of n is {}"
                        , Thread.currentThread().getName(), n);
            }
        }
    }

    public static void main(String[] args) {
        NumbersPrinter np1 = new NumbersPrinter();

        Thread t1 = new Thread(np1, "t1"); // t1.target --> np1
        t1.start(); // runs t1.run() --> t1.target.run() --> np1.run()

        // while creating a new thread object, we can pass an arrow function for a Runnable object
        // here ()->{} is the signature of `public void run()` method
        // new Thread(()->{}, "thread-name").start();
        // the arrow function supplied is the substitute for Thread.run() method
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                int n = new Random().nextInt(100, 200);
                log.trace("inside the arrow method, substituted for Runnable object, executed using the thread '{}', value of n is {}"
                        , Thread.currentThread().getName(), n);
            }
        }, "t2").start();

        // we can pass a method reference as a substitute for Runnable object as long as it is a void
        // method with no arguments.
        new Thread(ThreadDemo2::printSomeRandomNumbers, "t3").start();

        for (int i = 0; i < 15; i++) {
            int n = new Random().nextInt(100, 200);
            log.trace("inside the NumbersPrinter.main() executed using the thread '{}', value of n is {}"
                    , Thread.currentThread().getName(), n);
        }

    }

    static void printSomeRandomNumbers(){
        for (int i = 0; i < 15; i++) {
            int n = new Random().nextInt(100, 200);
            log.trace("inside printSomeRandomNumbers(), substituted for Runnable object, executed using the thread '{}', value of n is {}"
                    , Thread.currentThread().getName(), n);
        }
    }
}
