package com.tcm.api;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.tcm.hystrix.UserClientHystrix;

@FeignClient(value = "tcm-server",fallback = UserClientHystrix.class,primary=false)
public interface UserClient extends IHiService{
    
}

