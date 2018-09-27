package com.tcm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DemoConfig {

    @Value("${user.teleohone}")
    private String userTelephone;
    
    @Bean
    public DemoFoo demofoo() {
        
        return new DemoFoo(userTelephone);
    }
    @Profile("dev")
    @Bean("demofooDev")
    public DemoFoo demofooDev() {
        
        return new DemoFoo(userTelephone+"dev");
    }
}
