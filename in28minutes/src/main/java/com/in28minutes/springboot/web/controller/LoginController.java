package com.in28minutes.springboot.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String loginMessage(){
        return "Hello World";
    }
}

