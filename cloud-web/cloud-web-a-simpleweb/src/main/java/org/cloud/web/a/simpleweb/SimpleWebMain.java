package org.cloud.web.a.simpleweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableAutoConfiguration
@EnableEurekaClient // 向注册中心注册
@ComponentScan({ "org.cloud", "tcm" }) // 设置扫描的包
public class SimpleWebMain {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebMain.class, args);
    }
}
