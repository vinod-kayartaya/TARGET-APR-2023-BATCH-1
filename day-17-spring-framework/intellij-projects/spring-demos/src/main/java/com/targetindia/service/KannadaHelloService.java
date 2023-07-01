package com.targetindia.service;

public class KannadaHelloService implements HelloService{
    @Override
    public String getHelloMessage(String name) {
        return "ನಮಸ್ಕಾರ %s. ಹೇಗಿದ್ದೀಯಾ?".formatted(name);
    }
}
