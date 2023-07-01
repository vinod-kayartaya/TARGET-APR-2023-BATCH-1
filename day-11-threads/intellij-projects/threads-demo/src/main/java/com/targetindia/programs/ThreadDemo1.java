package com.targetindia.programs;

import com.targetindia.threads.MyThread;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread mt1;
        mt1 = new MyThread();
        mt1.setName("my-thread-1");

        for (int i = 0; i < 25; i++) {
            log.trace("first time, value of i in main() executed by the thread {} is {}",
                    Thread.currentThread().getName(), i);
        }

        // mt1.run(); // we should never call this; even if you call, the current thread is responsible for executing the run() method
        mt1.start(); // now there are (at least) two threads - "main", "my-thread-1"

        for (int i = 0; i < 25; i++) {
            log.trace("second time, value of i in main() executed by the thread {} is {}",
                    Thread.currentThread().getName(), i);
        }
    }
}
