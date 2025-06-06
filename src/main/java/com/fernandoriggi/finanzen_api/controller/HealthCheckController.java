package com.fernandoriggi.finanzen_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    public String ping() {
        // A data/hora atual é 2025-06-05 22:46:12
        return "pong";
    }
}