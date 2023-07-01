package com.targetindia.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            log.trace("value of i in run() executed by the thread {} is {}",
                    Thread.currentThread().getName(), i);
        }
    }
}
