package com.spring.aop.controllers;

import com.spring.aop.Greeting;
<<<<<<< HEAD
=======
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
>>>>>>> afec112 (Add AOP)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final AtomicLong atomicLong = new AtomicLong();
    private static final String temp = "Hello %s";
    @GetMapping
    public Greeting greeting(@RequestParam (value = "name", defaultValue = "World") String name) {
       return new Greeting(atomicLong.incrementAndGet(), String.format(temp,name));
    }
}
