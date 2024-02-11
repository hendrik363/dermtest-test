package com.hendrik.dermtest.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @SpringBootApplication
@Controller
// @ComponentScan("com.hendrikm")
public class MainController {
    
    // public static void main(String[] args) {
	// 	SpringApplication.run(MainController.class, args);
	// }
    
    @GetMapping("/")
    public String home() {
        return "homepage.html";
    }
}
