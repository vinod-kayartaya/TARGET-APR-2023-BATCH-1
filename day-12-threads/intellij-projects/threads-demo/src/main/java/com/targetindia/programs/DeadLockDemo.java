package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class DeadLockDemo {
    static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException {
        log.trace("Start of main()");

        // shared resources
        Object waterBottle = new Object();
        Object mug = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (waterBottle) {
                log.trace("{} acquired lock on water bottle", getThreadName());
                log.trace("{} is waiting for the mug", getThreadName());
                synchronized (mug) {
                    log.trace("{} got hold of the mug as well", getThreadName());
                    log.trace("{} is drinking water :-)", getThreadName());
                }
            }
        }, "Kiran");

        Thread t2 = new Thread(() -> {
            synchronized (mug) {
                log.trace("{} acquired lock on mug", getThreadName());
                log.trace("{} is waiting for the water bottle", getThreadName());
                synchronized (waterBottle) {
                    log.trace("{} got hold of the water bottle as well", getThreadName());
                    log.trace("{} is drinking water :-)", getThreadName());
                }
            }
        }, "Kishore");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        log.trace("End of main()");
    }
}
