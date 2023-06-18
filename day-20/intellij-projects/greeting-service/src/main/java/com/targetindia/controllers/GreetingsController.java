package com.targetindia.controllers;

import com.targetindia.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    public GreetingsController() {
        log.info("GreetingsController constructor called");
    }

    @GetMapping(produces = "text/plain")
    public String handleGetForText(){
        return "Hello, world!";
    }

    @GetMapping
    public Greeting handleGetForJsonAndXml(){
        return new Greeting("Hello, world!");
    }
}
