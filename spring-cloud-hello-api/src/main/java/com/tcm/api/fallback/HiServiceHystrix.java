package com.tcm.api.fallback;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.tcm.api.IHiService;
import com.tcm.api.vo.User;
/**
 * 
 * 一般情况下需要使用熔断器的在调用客户端自行处理
 *
 * @author zhang 2018年1月22日 下午8:31:05
 */
@Component
public class HiServiceHystrix implements IHiService{

    @Override
    public User hi4(String requestmodel) {
        System.out.println("HelloServiceHystrix....熔断");
        return null;
    }

    @Override
    public String tcmService() {
        // TODO Auto-generated method stub
        return null;
    }

}
