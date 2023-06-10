package com.targetindia.service;

public class ChineseHelloService implements HelloService{
    @Override
    public String getHelloMessage(String name) {
        return "你好，%s。你好吗？".formatted(name);
    }
}
