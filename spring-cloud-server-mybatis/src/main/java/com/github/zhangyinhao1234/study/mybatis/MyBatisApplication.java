package com.github.zhangyinhao1234.study.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@MapperScan(basePackages = {"com.github.zhangyinhao1234.study.mybatis.server.dao"})
@ComponentScan(value = { "com.github.zhangyinhao1234.study.mybatis.server",
        })
public class MyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }

}
