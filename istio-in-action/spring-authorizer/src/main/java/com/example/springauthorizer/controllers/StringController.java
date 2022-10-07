package com.example.springauthorizer.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class StringController {

    @Value("${the.string:default}")
    public String string = null;

    @GetMapping("/string")
    public String returnString() {
        return string == null ? "null" : string;
    }
}
