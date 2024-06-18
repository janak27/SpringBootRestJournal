package com.janak.journalapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    int count = 0;

    @GetMapping("/health-check")
    public String HealthCheck(){
        count = count + 1;
        System.out.println("ok terminal"+ count);
        return "ok api" ;
    }
}
