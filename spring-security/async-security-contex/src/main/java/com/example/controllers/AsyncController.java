package com.example.controllers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @GetMapping("/async")
    @Async
    public void printAsync() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
    }
}
