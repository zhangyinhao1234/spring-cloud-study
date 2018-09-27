package com.tcm.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcm.api.IHelloService3;
import com.tcm.service.UserV2;

@Component
public class HelloService3Hystrix implements IHelloService3 {
    public UserV2 hi4(String requestmodel) {
        System.out.println("HelloService3Hystrix:"+"熔断......");
        return null;
    }
}
