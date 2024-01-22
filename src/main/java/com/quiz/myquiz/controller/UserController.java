package com.quiz.myquiz.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
