package com.tcm.hystrix;

import org.springframework.stereotype.Component;

import com.tcm.api.UserClient;
import com.tcm.api.vo.User;
@Component
public class UserClientHystrix implements UserClient {

    @Override
    public User hi4(String requestmodel) {
        System.out.println("UserClientHystrix...... hi4 ");
        return null;
    }

    @Override
    public String tcmService() {
        // TODO Auto-generated method stub
        return null;
    }

}
