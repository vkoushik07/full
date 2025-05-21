package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/my")
public class teacher {
    @Autowired
    student s1;

    @GetMapping("/hello")
    public String getMethodName() {
        return "hello from teacher using devtoolss";
    }
    
}
