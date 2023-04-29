package com.targetindia.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestService implements AutoCloseable{

    public TestService() {
        log.trace("TestService() called");
    }

    public void doSomething(int arg) {
        log.trace("doing something..");
        if (arg == 0) {
            log.trace("throwing an exception..");
            throw new RuntimeException("arg was 0");
        }
        log.trace("nothing wrong here, exiting the TestService.doSomething() method");
    }

    public void close() {
        log.trace("TestService.close() called");
    }
}
