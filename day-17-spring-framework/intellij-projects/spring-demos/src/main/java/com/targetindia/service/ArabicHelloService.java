package com.targetindia.service;

import lombok.extern.slf4j.Slf4j;

public class ArabicHelloService implements HelloService {

    @Override
    public String getHelloMessage(String name) {
        return "مرحبا %s. كيف حالك؟".formatted(name);
    }
}
