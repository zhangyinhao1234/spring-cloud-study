package org.cloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Value("${spring.application.name:}")
    private String appName;

    @RequestMapping("/hello")
    public String hello(String hi) {
        return hi + "---->" + appName;
    }
}
