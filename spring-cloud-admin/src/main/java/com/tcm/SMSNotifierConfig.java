package com.tcm;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMSNotifierConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConfigurationProperties("spring.boot.admin.notify.sms")
    public SMSNotifier smsNotifier() {
        return new SMSNotifier();
    }
}
