package com.tcm.hystrix;

import org.springframework.stereotype.Component;

import com.tcm.api.HIClient;
import com.tcm.api.vo.User;

import feign.hystrix.FallbackFactory;
@Component
public class HIClientHystrixFactory implements FallbackFactory<HIClient> {

    @Override
    public HIClient create(Throwable cause) {
        return new HIClient() {
            
            @Override
            public String tcmService() {
                return null;
            }
            
            @Override
            public User hi4(String requestmodel) {
                System.out.println("HIClientHystrixFactory.....hi4");
                return null;
            }
        };
    }

}
