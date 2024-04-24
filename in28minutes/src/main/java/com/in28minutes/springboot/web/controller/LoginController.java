package com.in28minutes.springboot.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    public String loginMessage(){
        return "Hello World";
    }
}
