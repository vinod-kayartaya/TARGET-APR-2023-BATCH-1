package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorld {
    public static void main(String[] args) {
        log.trace("starting an endless loop..");
        for(;;);
    }
}
