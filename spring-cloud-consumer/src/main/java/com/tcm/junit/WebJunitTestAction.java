package com.tcm.junit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebJunitTestAction {
    
    

    @RequestMapping("/junit/test1")
    public String test1(String name) {
        return name;
    }
    
}
