package com.targetindia.service;

public class EnglishHelloService implements HelloService{
    @Override
    public String getHelloMessage(String name) {
        return "Hello, %s. How are you doing?".formatted(name);
    }
}
