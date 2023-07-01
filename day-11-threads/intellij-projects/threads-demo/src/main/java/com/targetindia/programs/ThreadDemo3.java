package com.targetindia.programs;

import java.util.Random;

public class ThreadDemo3 {
    void printSomeRandomNumbers(){
        // loop has not terminal condition; endless loop
        for (int i = 0; ; i++) {
            int n = new Random().nextInt(100, 200);
            System.out.printf("%d. thread name = '%s', value of n = %d%n"
                    , i+1, Thread.currentThread().getName(), n);
        }
    }

    public static void main(String[] args) {
        System.out.println("Start of ThreadDemo3.main()");
        ThreadDemo3 td3 = new ThreadDemo3();

        Thread t1 = new Thread(td3::printSomeRandomNumbers, "t001");
        Thread t2= new Thread(td3::printSomeRandomNumbers, "t002");

        // before we call the start() method on the threads mark them as 'daemon'
        t1.setDaemon(true); // when there are no more non-daemon threads alive, terminate yourself
        t2.setDaemon(true);

        t1.start();
        t2.start();

        for (int i = 0; i < 25; i++) {
            int n = new Random().nextInt(100, 200);
            System.out.printf("%d. thread name = '%s', value of n = %d%n"
                    , i+1, Thread.currentThread().getName(), n);
        }

        System.out.println("End of ThreadDemo3.main()");
        // the "main" thread terminates here, but the child threads t001 and t002 continue to be alive
    }
}
