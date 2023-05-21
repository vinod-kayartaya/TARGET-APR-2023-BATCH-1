package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLockSolutionDemo {
    static String getThreadName() {
        return Thread.currentThread().getName();
    }

    static void sleep(long duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
                    sleep(1000);
                    log.trace("{} done drinking", getThreadName());
                }
                log.trace("{} released his lock on the mug", getThreadName());
            }
            log.trace("{} released his lock on the water bottle", getThreadName());
        }, "Kiran");

        Thread t2 = new Thread(() -> {
            synchronized (waterBottle) {
                log.trace("{} acquired lock on water bottle", getThreadName());
                log.trace("{} is waiting for the mug", getThreadName());
                synchronized (mug) {
                    log.trace("{} got hold of the mug as well", getThreadName());
                    log.trace("{} is drinking water :-)", getThreadName());
                    sleep(1000);
                    log.trace("{} done drinking", getThreadName());
                }
                log.trace("{} released his lock on the mug", getThreadName());
            }
            log.trace("{} released his lock on the water bottle", getThreadName());
        }, "Kishore");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        log.trace("End of main()");
    }
}
