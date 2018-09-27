package com.tcm.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcm.hystrix.HelloServiceHystrix;
import com.tcm.service.UserV2;
/**
 * 
 * 远程调用
 * tcm-server：暴露的服务应用名
 * fallback:对方法调用进行熔断处理。
 *
 * @author zhang 2017年12月21日 下午7:03:14
 */
@FeignClient(value = "tcm-server")
public interface IHelloService2 {
    
    /**
     * 
     * 全json格式
     * 
     * @param requestmodel
     * @return
     */
    @RequestMapping("/service/hi4")
    UserV2 hi4(@RequestParam("requestmodel") String requestmodel);
}
